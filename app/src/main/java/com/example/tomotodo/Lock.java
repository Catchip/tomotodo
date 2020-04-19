package com.example.tomotodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.Time;
import java.util.List;

public class Lock extends AppCompatActivity {

    public Locks locks;
    public My_Timer my_timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
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

    public void addlock(View view){

    }

    public void deletelock(View view){

    }

    public void timer_running(){

    }
}


class Single_Lock{
    Time start;
    Time stop;
}

class Locks{
    List<Single_Lock> locks;
    public void addlock(){

    }

    public void deletelock(){

    }
}

class My_Timer{

}
