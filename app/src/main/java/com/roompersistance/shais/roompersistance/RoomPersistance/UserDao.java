package com.roompersistance.shais.roompersistance.RoomPersistance;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by shais on 01/26/2018.
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM Users")
    List<User> getAllUsers();

    @Query("SELECT COUNT(*) FROM Users")
    int numOfUsers();

    @Query("SELECT * FROM Users WHERE phone_number LIKE :phone_number")
    User getUser(String phone_number);

    @Insert
    void insertAll(List<User> users);

    @Delete
    void deleteUser(User user);

    @Delete
    void deleteUsers(List<User> users);
    @Delete
    void deleteAll(User user1, User user2);
    @Delete
    void deleteWithFriends(User user, List<User> friends);
}
