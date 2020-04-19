package com.example.tomotodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TodoList todolist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data_Save.load_data();
    }

    public void switchfuction(View view){
        Integer i = view.getId();
        switch (view.getId()){
            case R.id.button1:
                Intent intent0 = new Intent(this,MainActivity.class);
                startActivity(intent0);
                break;
            case R.id.button2:
                Intent intent1 = new Intent(this,Showdata_Activity.class);
                startActivity(intent1);
                break;
            case R.id.button3:
                Intent intent2 = new Intent(this,Lock.class);
                startActivity(intent2);
                break;
            default:
        }
    }

    public void add_todo(View view){

    }

    public void add_todolist(View view){

    }


    public void lock_mode(){

    }
}

class Todo {
    public String name;
    public double time;
}

class TodoList {
    public String name;
    public List<Todo> todos;
    public List<TodoList> todolists;
    public void add_todo(){

    }
    public void add_todolist(){

    }
    public void delete_todo(){

    }
    public void delete_todolist(){

    }
}
