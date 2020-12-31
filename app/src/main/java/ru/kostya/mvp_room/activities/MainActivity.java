package ru.kostya.mvp_room.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ru.kostya.mvp_room.R;
import ru.kostya.mvp_room.model.User;
import ru.kostya.mvp_room.presenter.UserPresenter;
import ru.kostya.mvp_room.presenterInterface.IUser;

public class MainActivity extends AppCompatActivity implements IUser {

    public static final String TAG ="jnjf";
    public static final int REQUEST_ADD = 1;

    private UserPresenter presenter;

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProgressDialog();
        presenter = new UserPresenter(this);

        presenter.getAllUser();
    }

    private void initProgressDialog() {
        pd = new ProgressDialog(this);
        pd.setTitle("Download");
        pd.setMessage("Please wait...");
    }

    @Override
    public void successAddedUser() {
        Log.d(TAG, "successAddedUser: ");
    }

    @Override
    public void failureAddedUser() {
        Log.d(TAG, "failureAddedUser: ");
    }

    @Override
    public void resultAdded(String message) {
        Log.d(TAG,  "message : " + message);
    }

    @Override
    public void updateListUser(List<User> allUsers) {
        for (User users: allUsers){
            Log.d(TAG, "updateListUser: ");
        }
    }

    @Override
    public void showLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        pd.dismiss();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD && resultCode == RESULT_OK && data != null){

            String name = data.getStringExtra(AddUserActivityy.EXTRA_NAME);
            String surName = data.getStringExtra(AddUserActivityy.EXTRA_SURNAME);

            presenter.insertUser(new User(name,surName));
        }

    }
}