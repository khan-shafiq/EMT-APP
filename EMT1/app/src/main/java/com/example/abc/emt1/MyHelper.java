package com.example.abc.emt1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper{

    private static final String dbname ="db1";
    private static final int version=1;

    public MyHelper(Context context){
        super( context,dbname,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE VOLUNTEER(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,P_NO STRING,pass STRING,OFFPIN STRING,HOMEPIN STRING)";
        db.execSQL(sql);

        insertData("Maaz","987654321","maa123","400050","400078",db);
        insertData("Amisha","9594753215","ami123","400071","400008",db);
        insertData("Shafiq","9137264699","sha123","400072","400002",db);
        insertData("Habib","987654321","hab123","400070","400001",db);
    }

    public void insertData(String name,String p_no,String pass,String offpin,String homepin, SQLiteDatabase database ){
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("P_NO", p_no);
        values.put("PASSWORD",pass);
        values.put("OFFPIN", offpin);
        values.put("HOMEPIN", homepin);
        database.insert("VOLUNTEER", null, values);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}