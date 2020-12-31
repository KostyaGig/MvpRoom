package ru.kostya.mvp_room.presenterInterface;

import java.util.List;

import ru.kostya.mvp_room.model.User;

public interface IUser extends ILoginView {

    void successAddedUser();

    void failureAddedUser();

    void resultAdded(String message);

    void updateListUser(List<User> allUsers);
}
