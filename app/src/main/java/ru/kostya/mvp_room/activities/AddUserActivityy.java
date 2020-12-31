package ru.kostya.mvp_room.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ru.kostya.mvp_room.R;

public class AddUserActivityy extends AppCompatActivity {

    public static final String EXTRA_NAME = "ru.kostya.mvvm_sql.activities.EXTRA_NAME";
    public static final String EXTRA_SURNAME = "ru.kostya.mvvm_sql.activities.EXTRA_SURNAME";

    private EditText edName,edSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_activityy);

        edName = findViewById(R.id.ed_name);
        edSurname = findViewById(R.id.ed_surname);
    }

    public void addUser(View view) {
        String name = edName.getText().toString().trim();
        String surName = edSurname.getText().toString().trim();

        Intent mainIntent = new Intent();
        mainIntent.putExtra(EXTRA_NAME,name);
        mainIntent.putExtra(EXTRA_SURNAME,surName);

        setResult(RESULT_OK,mainIntent);
        finish();
    }

}
