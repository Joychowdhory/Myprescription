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

public class NoonAlarmActivity extends AppCompatActivity {

    private TextView alarmtextviewID1;
    TimePicker timepickerID1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noon_alarm);
        alarmtextviewID1 = (TextView) findViewById(R.id.alarmtextviewID1);
        timepickerID1 = (TimePicker) findViewById(R.id.timepickerID1);

        findViewById(R.id.alarmbuttonID1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();

                if (Build.VERSION.SDK_INT >= 25) {
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timepickerID1.getHour(),
                            timepickerID1.getMinute(),
                            0
                    );

                } else {
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH),
                            timepickerID1.getCurrentHour(),
                            timepickerID1.getCurrentMinute(),
                            0
                    );
                }
                setAlarm(calendar.getTimeInMillis());


            }
        });

    }

    private void setAlarm(long timeInMillis) {

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, NoonAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0 , intent, 0);
        alarmManager.setRepeating(AlarmManager.RTC, timeInMillis, AlarmManager.INTERVAL_DAY,pendingIntent);
        Toast.makeText(this,"Alarm is set",Toast.LENGTH_SHORT).show();
    }

}


