package com.roompersistance.shais.roompersistance.RoomPersistance;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by shais on 01/26/2018.
 */
@Entity(tableName = "Users")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "last")
    String last;
    @ColumnInfo(name = "phone_number")
    String phone_number;

    public User(String name, String last, String phone_number) {
        this.name = name;
        this.last = last;
        this.phone_number = phone_number;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
