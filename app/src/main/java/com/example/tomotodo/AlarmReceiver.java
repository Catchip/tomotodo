package com.example.tomotodo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String endtime = intent.getStringExtra("endtime");
        Intent intent1 = new Intent(context,LockPage.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.putExtra("endtime",endtime);
        context.startActivity(intent1);
    }
}
