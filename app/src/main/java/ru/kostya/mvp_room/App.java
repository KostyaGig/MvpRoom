package ru.kostya.mvp_room;

import android.app.Application;

import ru.kostya.mvp_room.data.UserDao;
import ru.kostya.mvp_room.data.UserDatabase;
import ru.kostya.mvp_room.model.User;

public class App extends Application {

    private static App instance;
    private UserDao userDao;


    @Override
    public void onCreate() {
        super.onCreate();

        UserDatabase database = UserDatabase.getInstance(getApplicationContext());
        userDao = database.userDao();
    }

    public static App getInstance(){
        return instance;
    }

    public UserDao getUserDao(){
        return userDao;
    }

}
