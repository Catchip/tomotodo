package com.example.tomotodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lock extends AppCompatActivity {

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
            case R.id.button4:
                Intent intent3 = new Intent(this,Mine.class);
                startActivity(intent3);
                break;
            default:
                Button button = findViewById(R.id.button6);
                button.setText("assad");
        }
    }
}
