package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface BirthdayListItemDao {
    @Query("SELECT * FROM BirthdayListItem ORDER BY BirthdayListItem.nextBDay")
    List<BirthdayListItem> getAllItems();

    @Insert
    void insertAll(BirthdayListItem birthdayListItem);

    @Query("DELETE FROM BirthdayListItem")
    public void deleteAll();
}
