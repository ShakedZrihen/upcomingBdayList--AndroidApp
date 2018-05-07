package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.icu.util.Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class BirthdayListItem {

    @PrimaryKey(autoGenerate = true)
    private int _id;

    @ColumnInfo(name = "full_name")
    private String _fullName;

    @ColumnInfo(name = "birthday")
    private String _birthday;

    @ColumnInfo(name = "comment")
    private String _comment;

    @ColumnInfo(name = "nextBDay")
    private int _nextBDay;


    public BirthdayListItem(String fullName, String birthday, String comment, int nextBDay){
        setFullName(fullName);
        setBirthday(birthday);
        setComment(comment);
        set_nextBDay(nextBDay);
    }

    //    Getters
    public int getId() { return _id; }

    public String getFullName() { return _fullName; }

    public String getBirthday() { return _birthday; }

    public String getComment(){ return _comment; }

    public String getAge() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date convertedDate = dateFormat.parse(_birthday);

        Calendar birhday = Calendar.getInstance();
        birhday.setTime(convertedDate);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birhday.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < birhday.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = Integer.valueOf(age);
        String ageS = ageInt.toString();

        return ageS;


    }

    public int getNextBDay(){return _nextBDay;}

    //    Setters
    public void setComment(String description){ _comment = description; }

    public void setFullName(String fullName) { _fullName = fullName; }

    public void setBirthday(String birthday) { _birthday = birthday; }

    public void setId(int id){_id = id;}

    public void set_nextBDay(int nextBday){ _nextBDay = nextBday;}
}
