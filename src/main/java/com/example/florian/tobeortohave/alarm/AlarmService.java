package com.example.florian.tobeortohave.alarm;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public class AlarmService {
    private Context context;
    private PendingIntent alarmIntent;
    private AlarmManager alarmMgr;

    public AlarmService(Context context) {
        this.context = context;
    }

    public void startAlarm() {
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent;
        PendingIntent pendingIntent;


        myIntent = new Intent(context,AlarmNotificationReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(context,0,myIntent,0);


        manager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+3000,pendingIntent);

    }
}

