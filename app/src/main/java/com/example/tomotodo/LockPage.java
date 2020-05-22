package com.example.tomotodo;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class LockPage extends AppCompatActivity {
    private Button show_end_time;
    CountDownTimer timer;
    Calendar calendar;
    int end_hour;
    int end_min;
    boolean flag =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_page);
        Intent intent = getIntent();

        String endtime = intent.getStringExtra("endtime");
        show_end_time = (Button) findViewById(R.id.show_end_time);
        show_end_time.setText(endtime+" to end");
        String []hourmin = endtime.split(":");
        end_hour = Integer.parseInt(hourmin[0]);
        end_min = Integer.parseInt(hourmin[1]);
        timer = new CountDownTimer(24*60*60*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);

                if(hour==end_hour&&min ==end_min && flag == false){
                    flag= true;
                    Intent intent1 = new Intent(LockPage.this,MainActivity.class);
                    startActivity(intent1);
                }

            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }
}
