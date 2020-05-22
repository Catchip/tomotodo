package com.example.tomotodo;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TodoList todolist;
    private ViewPager viewpager;
    private Toolbar toolbar;
    private TabLayout tablayout;
    private FloatingActionButton fab;
    private MyDatabaseHelper dbHelper;
    private String startlock;
    private String starttime;
    private String endtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data_Save.load_data();
        dbHelper = new MyDatabaseHelper(this,"Data.db",null,2);
        dbHelper.getWritableDatabase();
        Intent intent = getIntent();
        startlock = intent.getStringExtra("startlock");
        starttime = intent.getStringExtra("starttime");
        endtime = intent.getStringExtra("endtime");
        Toast.makeText(getApplicationContext(), startlock,Toast.LENGTH_SHORT).show();
        if(startlock!=null) StartLock(starttime,endtime);
        initViewPager();
    }

    private void StartLock(String starttime,String endtime){

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this,AlarmReceiver.class);
        intent.putExtra("endtime",endtime);
        String [] hourmin = starttime.split(":");
        int hour = Integer.parseInt(hourmin[0]);
        int min = Integer.parseInt(hourmin[1]);
        Toast.makeText(getApplicationContext(), Integer.toString(hour)+":"+Integer.toString(min),Toast.LENGTH_SHORT).show();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
    private void initViewPager() {

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, new_lock.class);
                startActivityForResult(intent, 1);
            }
        });
        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewPager);
        List<String> titles = new ArrayList<>();
        titles.add("Lock");
        titles.add("Todo");
        titles.add("Data");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LockFragment());
        fragments.add(new ClockFragment());
        fragments.add(new DataFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);

        viewpager.setAdapter(fragmentAdapter);
        tablayout.setupWithViewPager(viewpager);
        viewpager.addOnPageChangeListener(pageChangeListener);

    }


    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (position == 0) {
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, new_lock.class);
                        startActivityForResult(intent, 1);
                    }
                });
            } else {
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, new_todo.class);
                        startActivity(intent);
                    }
                });
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

        public void add_todo(View view) {

        }

        public void add_todolist(View view) {

        }


        public void lock_mode() {

        }

        private void initPermission() {
            String permission[] = {Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.INTERNET,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.RECEIVE_BOOT_COMPLETED,
                    Manifest.permission.ACCESS_NOTIFICATION_POLICY
            };
            ArrayList<String> applyList = new ArrayList<>();

            for (String per : permission) {
                if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, per)) {
                    applyList.add(per);
                }
            }

            String tmpList[] = new String[applyList.size()];
            if (!applyList.isEmpty()) {
                ActivityCompat.requestPermissions(this, applyList.toArray(tmpList), 123);
            }
        }

    };

class Todo {
    public String name;
    public double time;

    public String getTitle() {
        return name;
    }
    public void setTitle(String title){name = title;};
}

class Lock {
    public String name;
    public String  start;
    public String end;
    public boolean isON ;

    public String getTitle() {
        return name;
    }
    public void set(){
        isON = !isON;
    }
    public void setTitle(String title){name = title;};
    public void setStart(String mstart){start=mstart;};
    public void setEnd(String mend){end=mend;};
    public String  getStart(){return start;};
    public String getEnd(){return  end;};


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

