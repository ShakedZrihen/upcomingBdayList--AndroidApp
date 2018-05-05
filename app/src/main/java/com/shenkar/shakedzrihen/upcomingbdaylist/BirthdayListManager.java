package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class BirthdayListManager extends AppCompatActivity {

    EditText fullName;
    EditText birthday;
    Button addBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_birthday);
        fullName = findViewById(R.id.fullName);
        birthday = findViewById(R.id.birthday);
        addBtn = findViewById(R.id.addBirthdayBtn);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
