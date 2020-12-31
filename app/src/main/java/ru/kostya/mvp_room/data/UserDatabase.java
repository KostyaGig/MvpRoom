package ru.kostya.mvp_room.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ru.kostya.mvp_room.model.User;

@Database(entities = User.class,version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase  {

    private static UserDatabase database;

    public abstract UserDao userDao();

    public static synchronized UserDatabase getInstance(Context context){
        if (database == null){
            database = Room.databaseBuilder(context,UserDatabase.class,"user.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }

}
