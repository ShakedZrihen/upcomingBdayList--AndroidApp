package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class AddNewBirthdayListItem extends AppCompatActivity {

    EditText _fullName;
    BirthdayPicker _birthday;
    EditText _comment;
    Button _addBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_birthday);
        _fullName = findViewById(R.id.fullName);
        _birthday = new BirthdayPicker(AddNewBirthdayListItem.this, (EditText) findViewById(R.id.birthday));
        _comment = findViewById(R.id.comment);
        _addBtn = findViewById(R.id.addBirthdayBtn);


        //  Set listeners
        _addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
