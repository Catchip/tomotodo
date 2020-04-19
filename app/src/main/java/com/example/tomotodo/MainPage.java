package com.example.tomotodo;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainPage extends View{
    public Button add_todo_button;
    public Button add_todolist_button;
    public Button switch_to_main;
    public Button switch_to_lock;
    public Button switch_to_showdata;
    public List<Todo_button> todo_lists;

    public MainPage(Context context) {
        super(context);
    }

    public void add_todo_button_clicked(View view){

    }
    public void add_todolist_button_clicked(View view){

    }
    public void todo_button_clicked(View view){

    }
    public void todo_button_long_press(View view){

    }
    public void switch_to_any_clicked(View view){

    }
}

class Todo_button{
    public Button self;
    public List<Button> lists;
}

