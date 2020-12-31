package ru.kostya.mvp_room.presenter;

import ru.kostya.mvp_room.App;
import ru.kostya.mvp_room.data.UserDao;
import ru.kostya.mvp_room.model.User;
import ru.kostya.mvp_room.presenterInterface.IUser;

public class UserPresenter {

    private IUser interfaceUser;
    private UserDao userDao = App.getInstance().getUserDao();

    public UserPresenter(IUser interfaceUser){
        this.interfaceUser = interfaceUser;
    }

    public void insertUser(User user){
        interfaceUser.showLoading();
        userDao.insertUser(user);
        interfaceUser.hideLoading();
        interfaceUser.resultAdded("Nice, user was added");
        interfaceUser.successAddedUser();
        interfaceUser.updateListUser(userDao.getAllUsers());
    }

    public void getAllUser(){
        interfaceUser.showLoading();
        interfaceUser.updateListUser(userDao.getAllUsers());
        interfaceUser.hideLoading();
    }

}
