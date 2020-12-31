package ru.kostya.mvp_room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "user_table")
public class User {

    @ColumnInfo(name = "_id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "surname")
    private String surName;

    public User(){

    }

    public User(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }


}
