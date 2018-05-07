package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView birthdayList;
    RecyclerView.Adapter birthdayListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        birthdayList = findViewById(R.id.birthday_list);
        birthdayList.setLayoutManager(new LinearLayoutManager(this));


        AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "BirthdayListDB"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build();


        List<BirthdayListItem> bdListItems = db.birthdayListItemDao().getAllItems();

        birthdayListAdapter = new BirthdayListAdapter(bdListItems);
        birthdayList.setAdapter(birthdayListAdapter);
        FloatingActionButton addNewListItem = (FloatingActionButton) findViewById(R.id.fab);


        addNewListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNewBirthdayListItem.class));

            }
        });
    }

}
