package com.example.tomotodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Showdata_Activity extends AppCompatActivity {
    public Button switch_to_main;
    public Button switch_to_lock;
    public Button switch_to_showdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata_);
        draw_graph();
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
    public void draw_graph(){

    }
}
