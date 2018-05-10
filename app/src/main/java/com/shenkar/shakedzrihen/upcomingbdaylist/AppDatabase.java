package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {BirthdayListItem.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    public abstract BirthdayListItemDao birthdayListItemDao();
}
