package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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

        final AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "BirthdayListDB"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        //  Set listeners
        _addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db.birthdayListItemDao().insertAll(
                            new BirthdayListItem(
                                    _fullName.getText().toString(),
                                    _birthday.getBirthday(),
                                    _comment.getText().toString(),
                                    generateNextBDay(_birthday.getBirthday())
                            )
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(AddNewBirthdayListItem.this, MainActivity.class));
            }
        });
    }

    public int generateNextBDay(String birthday) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date convertedDate = dateFormat.parse(birthday);

        Calendar birhday = Calendar.getInstance();
        birhday.setTime(convertedDate);
        Calendar today = Calendar.getInstance();

        int nextBday = 0;

        if ( birhday.get(Calendar.MONTH) >= today.get(Calendar.MONTH)){
            nextBday = birhday.get(Calendar.MONTH) - today.get(Calendar.MONTH);
            if (birhday.get(Calendar.DAY_OF_MONTH) >= today.get(Calendar.DAY_OF_MONTH)){
                nextBday += birhday.get(Calendar.DAY_OF_MONTH) - today.get(Calendar.DAY_OF_MONTH);
            } else {
                nextBday += today.get(Calendar.DAY_OF_MONTH) - birhday.get(Calendar.DAY_OF_MONTH);
            }
        } else {
            nextBday = 12 - (today.get(Calendar.MONTH) - birhday.get(Calendar.MONTH));
            if (birhday.get(Calendar.DAY_OF_MONTH) >= today.get(Calendar.DAY_OF_MONTH)){
                nextBday += birhday.get(Calendar.DAY_OF_MONTH) - today.get(Calendar.DAY_OF_MONTH);
            } else {
                nextBday += today.get(Calendar.DAY_OF_MONTH) - birhday.get(Calendar.DAY_OF_MONTH);
            }
        }
        return nextBday;
    }
}
