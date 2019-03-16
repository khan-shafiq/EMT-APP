package com.example.abc.emt1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME  = "hackathon.db";
    public static final int DB_VERSION = 2;
    public static final String USER_TABLE = "USER";
    public static final String id = "UID";
    public static final String full_name = "FULL_NAME";
    public static final String mobile = "MOBILE";
    public static final String email = "EMAIL";
    public static final String bloodgrp = "BLOOD_GROUP";

//    public static final String USER_CREATE_QUERY = "CREATE TABLE "+
//            USER_TABLE+"("+id+" INTEGER PRIMARYKEY AUTOINCREMENT,"+full_name+" TEXT)";
//    public static final String USER_CREATE_QUERY =
//        "CREATE TABLE USER(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
////        "FULL_NAME TEXT,MOBILE TEXT)";
//        "FULL_NAME TEXT,MOBILE TEXT)";

    public static final String USER_CREATE_QUERY = "CREATE TABLE "+USER_TABLE+
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "FULL_NAME TEXT,"+
            "EMAIL TEXT,"+
            "BLOODGRP TEXT,"+
            "MOBILE TEXT)";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS USER";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(USER_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
