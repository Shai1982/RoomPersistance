package com.roompersistance.shais.roompersistance.RoomPersistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by shais on 01/26/2018.
 */
@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao UserDao();
}
