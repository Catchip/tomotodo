package com.example.tomotodo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class new_todo extends AppCompatActivity {

    private FloatingActionButton fab_start;
    private TextView edit_title;
    private String todo_title;
    private Todo todo;
    private MyDatabaseHelper mdbHelper;
    private SQLiteDatabase db;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_todo);
        mdbHelper = new MyDatabaseHelper(new_todo.this, "Data.db", null, 2);
        db = mdbHelper.getWritableDatabase();
        initView();
        initClick();
    }
    private void initView(){
        fab_start = (FloatingActionButton) findViewById(R.id.fab_start);
        edit_title = (TextView) findViewById(R.id.edit_clock_title);
    }

    private void initClick(){
        fab_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ContentValues values = new ContentValues();
                todo_title = edit_title.getText().toString();
                todo = new Todo();
                todo.setTitle(todo_title);
                values.put("clocktitle",todo_title);
                db.insert("Clock",null,values);
                Intent intent = new Intent(new_todo.this, tomato_mode.class);
                intent.putExtra("clocktitle",todo_title);
                startActivity(intent);
                finish();
            }
        });




    }

}
