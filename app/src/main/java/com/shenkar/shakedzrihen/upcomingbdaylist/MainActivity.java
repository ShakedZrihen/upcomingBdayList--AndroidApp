package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView birthdayList;
    RecyclerView.Adapter birthdayListAdapter;
    ArrayList<BirthdayListItem> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        birthdayList = findViewById(R.id.birthday_list);
        birthdayList.setLayoutManager(new LinearLayoutManager(this));
        names = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BirthdayListItem newList = new BirthdayListItem(
                    "Shaked #" + i,
                    (i+1) + "-2-1994",
                    "This is comment #" + i
            );
            names.add(newList);
        }
        birthdayListAdapter = new BirthdayListAdapter(names);
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
