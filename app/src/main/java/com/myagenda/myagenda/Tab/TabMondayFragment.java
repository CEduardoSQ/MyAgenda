package com.myagenda.myagenda.Tab;


import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myagenda.myagenda.AddClassActivity;
import com.myagenda.myagenda.ItemCard;
import com.myagenda.myagenda.R;
import com.myagenda.myagenda.RecyclerViewAdapter;
import com.myagenda.myagenda.SQLiteManager;
import com.myagenda.myagenda.Utilities;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabMondayFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ItemCard> itemCardsList;
    RecyclerViewAdapter recyclerViewAdapter;
    SQLiteManager sqLiteManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_tab_monday, container, false);
        itemCardsList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.rvClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        sqLiteManager = new SQLiteManager((AddClassActivity) getActivity().getApplicationContext(), "database", null, 1);

        CheckList();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(itemCardsList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void CheckList() {
        SQLiteDatabase database = sqLiteManager.getReadableDatabase();

        itemCardsList.add(new ItemCard("CAS", "9:00", "11:00"));
        itemCardsList.add(new ItemCard("SCIENCE", "11:00", "13:00"));
    }

}
