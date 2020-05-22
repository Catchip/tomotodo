package com.example.tomotodo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


public class TomatoUtils {


    /**
     * 返回数据库用户所有的番茄钟
     *
     * @param context
     * @return
     * @throws Exception
     */
    public static List<Todo> getAllTomato(Context context) {
        List<Todo> temp = new ArrayList<Todo>();
        List<Todo> findAll = getDbAllTomato(context);
        Log.i("ClockDao","番茄任务个数" + findAll.size());
        if (findAll != null && findAll.size() > 0) {
            temp.addAll(findAll);
        }
        return temp;
    }

    public static List<Lock> getAllLock(Context context) {
        List<Lock> temp = new ArrayList<Lock>();
        List<Lock> findAll = getDbAllLock(context);
        Log.i("ClockDao","Lock个数" + findAll.size());
        if (findAll != null && findAll.size() > 0) {
            temp.addAll(findAll);
        }
        return temp;
    }

    public interface GetTomatoCallBack {
        void onSuccess(List<Todo> tomato);

        void onError(int errorCode, String msg);
    }

    public interface DeleteTomatoListener {
        void onSuccess();

        void onError(int errorCord, String msg);
    }

    public static List<Todo> getDbAllTomato(Context context) {
        MyDatabaseHelper  mDbHelper = new MyDatabaseHelper(context,"Data.db", null, 2);
        SQLiteDatabase  db = mDbHelper.getWritableDatabase();

        List<Todo> tomatoList = new ArrayList<Todo>();
        Cursor cursor=db.rawQuery("SELECT * FROM Clock", null);
        while(cursor.moveToNext()) {
            Todo data = new Todo();
            data.setTitle(cursor.getString(cursor.getColumnIndex("clocktitle")));
            tomatoList.add(data);
        }
        // make sure to close the cursor

        cursor.close();
        mDbHelper.close();
        Log.i("ClockDao", "查询到本地的番茄任务个数：" + tomatoList.size());
        return tomatoList;
    }


    public static List<Lock> getDbAllLock(Context context) {
        MyDatabaseHelper  mDbHelper = new MyDatabaseHelper(context,"Data.db", null, 2);
        SQLiteDatabase  db = mDbHelper.getWritableDatabase();

        List<Lock> lockList = new ArrayList<Lock>();
        Cursor cursor=db.rawQuery("SELECT * FROM Lock", null);
        while(cursor.moveToNext()) {
            Lock data = new Lock();
            data.setTitle(cursor.getString(cursor.getColumnIndex("locktitle")));
            data.setEnd(cursor.getString(cursor.getColumnIndex("end_time")));
            data.setStart(cursor.getString(cursor.getColumnIndex("start_time")));
            lockList.add(data);
        }
        // make sure to close the cursor

        cursor.close();
        mDbHelper.close();
        Log.i("lockDao", "查询到本地的锁机个数：" + lockList.size());
        return lockList;
    }
}
