package com.myagenda.myagenda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduar on 14/02/2018.
 */

public class SQLiteManager extends SQLiteOpenHelper {

    private static final String NAME = "database";
    private static final int VERSION = 1;

    public SQLiteManager(AddClassActivity addClassActivity, String dataBaseClass, Context context, int i) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilities.CREATE_TABLE_CLASS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS class");
        onCreate(sqLiteDatabase);
    }

    public List<ItemCard> showClass() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + Utilities.TABLE_CLASS, null);
        List<ItemCard> itemCardList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                itemCardList.add(new ItemCard(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        return itemCardList;
    }
}
