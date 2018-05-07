package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;

public interface BirthdayListItemDao {
    @Query("SELECT * FROM BirthdayListItem ORDER BY BirthdayListItem.birthday ")
    ArrayList<BirthdayListItem> getAllItems();

    @Insert
    void insertAll(BirthdayListItem birthdayListItems);
}
