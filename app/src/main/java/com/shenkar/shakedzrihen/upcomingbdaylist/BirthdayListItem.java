package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

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


    public BirthdayListItem(String fullName, String birthday, String comment) {
        setFullName(fullName);
        setBirthday(birthday);
        setComment(comment);
    }

    //    Getters
    public int getId() { return _id; }

    public String getFullName() { return _fullName; }

    public String getBirthday() { return _birthday; }

    public String getComment(){ return _comment; }


    //    Setters
    public void setComment(String description){ _comment = description; }

    public void setFullName(String fullName) { _fullName = fullName; }

    public void setBirthday(String birthday) { _birthday = birthday; }

    public void setId(int id){_id = id;}
}
