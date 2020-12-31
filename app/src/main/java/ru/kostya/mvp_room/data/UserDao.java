package ru.kostya.mvp_room.data;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.kostya.mvp_room.model.User;

public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user_table")
    List<User> getAllUsers();
}
