package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class AddNewBirthdayListItem extends AppCompatActivity {

    EditText _fullName;
    Birthday _birthday;
    Button _addBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_birthday);
        _fullName = findViewById(R.id.fullName);
        _birthday = new Birthday(AddNewBirthdayListItem.this, (EditText) findViewById(R.id.birthday));
        _addBtn = findViewById(R.id.addBirthdayBtn);

        _addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
