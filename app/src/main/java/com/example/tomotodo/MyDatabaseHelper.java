package com.example.tomotodo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String LOCK = "create table Lock ("
            + "id integer primary key autoincrement, "
            + "locktitle String,"
            + "start_time String,"
            + "ison Boolen,"
            + "end_time String)";

    public static final String CLOCK = "create table Clock ("
            + "id integer primary key autoincrement,"
            + "objectId String,"
            + "clocktitle String)";

    public static final String TIME = "create table timer_schedule ("
            + "_id integer primary key autoincrement,"
            + "clocktitle String,"
            + "start_time DATETIME,"
            + "end_time DATETIME)";


    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(LOCK);
        db.execSQL(CLOCK);
        db.execSQL(TIME);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists LOCK");
        db.execSQL("drop table if exists Clock");
        db.execSQL("drop table if exists timer_schedule");
        onCreate(db);
    }
}
