package com.example.tomotodo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TodoList todolist;
    private ViewPager viewpager;
    private Toolbar toolbar;
    private TabLayout tablayout;
    private FloatingActionButton  fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data_Save.load_data();
        initViewPager();
    }

    private void initViewPager(){

        fab = (FloatingActionButton) findViewById(R.id.fab);
        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewPager);
        List<String> titles = new ArrayList<>();
        titles.add("Lock");
        titles.add("Todo");
        titles.add("Data");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new  LockFragment());
        fragments.add(new  ClockFragment());
        fragments.add(new  DataFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        
        viewpager.setAdapter(fragmentAdapter);
        tablayout.setupWithViewPager(viewpager);




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

    private void initPermission() {
        String permission[] = { Manifest.permission.RECORD_AUDIO,
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
