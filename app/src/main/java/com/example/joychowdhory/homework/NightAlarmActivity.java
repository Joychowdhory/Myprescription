package com.example.joychowdhory.homework;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NightAlarmActivity extends AppCompatActivity {

    private TextView alarmtextviewID2;
    TimePicker timepickerID2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_alarm);


        alarmtextviewID2 = (TextView) findViewById(R.id.alarmtextviewID2);
        timepickerID2 = (TimePicker) findViewById(R.id.timepickerID2);

        findViewById(R.id.alarmbuttonID2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();

                if (Build.VERSION.SDK_INT >= 25) {
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timepickerID2.getHour(),
                            timepickerID2.getMinute(),
                            0
                    );

                } else {
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timepickerID2.getCurrentHour(),
                            timepickerID2.getCurrentMinute(),
                            0
                    );
                }
                setAlarm(calendar.getTimeInMillis());


            }
        });

    }

    private void setAlarm(long timeInMillis) {

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, NightAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0 , intent, 0);
        alarmManager.setRepeating(AlarmManager.RTC, timeInMillis, AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(this,"Alarm is set",Toast.LENGTH_SHORT).show();
    }

}


