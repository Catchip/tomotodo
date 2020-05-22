package com.example.tomotodo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class new_lock extends AppCompatActivity {

    private FloatingActionButton fab_add;
    private TextView edit_title;
    private TextView edit_start_time;
    private TextView edit_end_time;
    private String lock_title;
    private String start_time;
    private String end_time;
    private Lock lock;
    private MyDatabaseHelper mdbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lock);
        mdbHelper = new MyDatabaseHelper(new_lock.this, "Data.db", null, 2);
        db = mdbHelper.getWritableDatabase();
        initView();
        initClick();
    }

    private void initView(){
        fab_add = (FloatingActionButton) findViewById(R.id.fab_add_lock);
        edit_title = (TextView) findViewById(R.id.edit_lock_title);
        edit_start_time = (TextView) findViewById(R.id.input_start_time);
        edit_end_time = (TextView) findViewById(R.id.input_end_time);
    }

    private void initClick() {
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                lock_title = edit_title.getText().toString();
                start_time = edit_start_time.getText().toString();
                end_time =  edit_end_time.getText().toString();
                lock = new Lock();
                lock.setTitle(lock_title);
                values.put("locktitle", lock_title);
                values.put("start_time", start_time);
                values.put("end_time", end_time);
                db.insert("Lock", null, values);
                Intent intent = new Intent(new_lock.this, MainActivity.class);
                intent.putExtra("locktitle", lock_title);
                startActivity(intent);
                finish();
            }
        });

    }
}
