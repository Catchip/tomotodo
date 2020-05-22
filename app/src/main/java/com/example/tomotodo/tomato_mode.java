package com.example.tomotodo;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class tomato_mode extends AppCompatActivity {
    private CountDownTimer timer;
    private CountDownTimer timer2;
    private Button btn_start;
    private Button btn_skip;
    private Button btn_quit;
    private Button btn_title;
    private Button show_time;
    private MyDatabaseHelper dbhelper;
    private SQLiteDatabase db;
    private Time starttime;
    private Time endTime;
    private String clock_title;
    private static final SimpleDateFormat formatDateTime =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private static final SimpleDateFormat formatDate =
            new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato_mode);
        Intent intent = getIntent();
        clock_title = intent.getStringExtra("clocktitle");
        btn_start = (Button) findViewById(R.id.button_start);
        btn_quit = (Button) findViewById(R.id.button_stop);
        btn_skip = (Button) findViewById(R.id.button_skip);
        btn_title =  (Button) findViewById(R.id.button_title);
        btn_title.setText(clock_title);
        show_time = (Button) findViewById(R.id.show_time);
        timer = new CountDownTimer(25*60*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int remaintime = (int) millisUntilFinished/1000;
                show_time.setText("番茄时间:"+Integer.toString(remaintime));
            }

            @Override
            public void onFinish() {
                ContentValues values = new ContentValues();
                endTime = null;
                values.put("start_time",formatDateTime.format(starttime));
                values.put("end_time",formatDateTime.format(endTime));
                values.put("clocktitle",clock_title);
                db.insert("Time",null,values);
                btn_quit.setVisibility(View.GONE);
                btn_skip.setVisibility(View.VISIBLE);
                timer2.start();
            }
        };
        timer2 = new CountDownTimer(5*60*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int remaintime = (int) millisUntilFinished/1000;
                show_time.setText("休息时间:"+Integer.toString(remaintime));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(tomato_mode.this,MainActivity.class);
                startActivity(intent);
            }
        };
        initActions();

    }

    private void initActions(){
        btn_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                starttime = null;
                timer.start();
                btn_start.setVisibility(View.GONE);
                btn_quit.setVisibility(View.VISIBLE);
            }
        });
        btn_quit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               final AlertDialog.Builder dialog = new AlertDialog.Builder(tomato_mode.this);
               dialog.setMessage("取消后番茄钟将作废");
               dialog.setTitle("提示");
               dialog.setPositiveButton("确定",
                       new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Intent intent = new Intent(tomato_mode.this,MainActivity.class);
                               startActivity(intent);
                           }
                       });
               dialog.setNegativeButton("取消",
                       new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.dismiss();
                           }
                       });
               dialog.show();
            }

        });


        btn_skip.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(tomato_mode.this);
                dialog.setMessage("是否略过休息时间");
                dialog.setTitle("提示");
                dialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(tomato_mode.this,MainActivity.class);
                                startActivity(intent);
                            }
                        });
                dialog.setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dialog.show();
            }

        });
    }

    public void start_tomoto_mode(){

    }
    public void pause_button_clicked(){

    }
    public void stop_button_clicked(){

    }
    public void resume_button_clicked(){

    }


}
