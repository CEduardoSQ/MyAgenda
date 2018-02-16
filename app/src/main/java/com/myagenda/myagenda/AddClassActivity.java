package com.myagenda.myagenda;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import petrov.kristiyan.colorpicker.ColorPicker;

public class AddClassActivity extends AppCompatActivity implements View.OnClickListener {

    Button btStarts, btEnds, btPickColor;
    EditText etClass;
    TextView tvStarts, tvEnds;
    private int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        etClass = (EditText) findViewById(R.id.etClass);
        tvStarts = (TextView) findViewById(R.id.tvStarts);
        tvEnds = (TextView) findViewById(R.id.tvEnds);

        btStarts = (Button) findViewById(R.id.btStarts);
        btEnds = (Button) findViewById(R.id.btEnds);
        btPickColor = (Button) findViewById(R.id.btPickColor);

        btStarts.setOnClickListener(this);
        btEnds.setOnClickListener(this);
        btPickColor.setOnClickListener(this);
    }


    public void opencolorpicker() {
        final ColorPicker colorPicker = new ColorPicker(this);
        ArrayList<String> color = new ArrayList<>();
        color.add("#F44336");
        color.add("#E91E63");
        color.add("#9C27B0");
        color.add("#673AB7");
        color.add("#3F51B5");
        color.add("#2196F3");
        color.add("#03A9F4");
        color.add("#00BCD4");
        color.add("#009688");
        color.add("#4CAF50");
        color.add("#8BC34A");
        color.add("#CDDC39");
        color.add("#FFEB3B");
        color.add("#FFC107");
        color.add("#FF9800");
        color.add("#FF5722");
        color.add("#795548");
        color.add("#9E9E9E");
        color.add("#607D8B");
        color.add("#000000");

        colorPicker.setColors(color)
                .setColumns(5)
                .setRoundColorButton(true)
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        btPickColor.setBackgroundColor(color);
                    }

                    @Override
                    public void onCancel() {

                    }
                }).show();
    }

    @Override
    public void onClick(View view) {

        if (view == btPickColor) {
            opencolorpicker();
        }

        if (view == btStarts) {
            final Calendar calendar = Calendar.getInstance();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    if (minute < 10) {
                        tvStarts.setText(hour + ":" + "0" + minute);
                    } else {
                        tvStarts.setText(hour + ":" + minute);
                    }
                }
            }, hour, minute, false);
            timePickerDialog.show();
        }
        if (view == btEnds) {
            final Calendar calendar = Calendar.getInstance();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    if (minute < 10) {
                        tvEnds.setText(hour + ":" + "0" + minute);
                    } else {
                        tvEnds.setText(hour + ":" + minute);
                    }
                }
            }, hour, minute, false);
            timePickerDialog.show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save) {
            classRegister();
            final Intent launchMainActivity = new Intent(AddClassActivity.this, MainActivity.class);
            startActivity(launchMainActivity);
        }
        return true;
    }

    private void classRegister() {
        SQLiteManager sqLiteManager = new SQLiteManager(this, "DataBaseClass", null, 1);
        SQLiteDatabase database = sqLiteManager.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Utilities.FIELD_CLASS, etClass.toString());
        contentValues.put(Utilities.FIELD_STARTS, tvStarts.toString());
        contentValues.put(Utilities.FIELD_ENDS, tvEnds.toString());

        Long idResult = database.insert(Utilities.TABLE_CLASS, Utilities.FIELD_CLASS, contentValues);

        final Intent launchMainActivity = new Intent(AddClassActivity.this, MainActivity.class);
        startActivity(launchMainActivity);

        Toast.makeText(getApplicationContext(), "ADDED CORRECTLY", Toast.LENGTH_SHORT).show();

        database.close();
    }
}