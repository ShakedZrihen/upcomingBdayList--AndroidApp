package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity
public class BirthdayListItem {

    @PrimaryKey(autoGenerate = true)
    private int _id;

    private String _fullName;

    private String _birthday;

    private String _comment;


    public BirthdayListItem(String fullName, String birthday, String comment) {
        setFullName(fullName);
        setBirthday(birthday);
        setComment(comment);
    }

    //    Getters
    public String getFullName() { return _fullName; }

    public String getBirthday() { return _birthday; }

    public String getComment(){ return _comment; }


    //    Setters
    public void setComment(String description){ _comment = description; }

    public void setFullName(String fullName) { _fullName = fullName; }

    public void setBirthday(String birthday) { _birthday = birthday; }
}
