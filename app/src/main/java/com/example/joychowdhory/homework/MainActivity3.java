package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {


    private Button morningalarmID;
    private Button noonalarmID;
    private Button nightalarmID;
    private TextView alarmtextviewID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        alarmtextviewID = (TextView) findViewById(R.id.alarmtextviewID);

        morningalarmID = (Button) findViewById(R.id.morningalarmID);
        noonalarmID = (Button) findViewById(R.id.noonalarmID);
        nightalarmID = (Button) findViewById(R.id.nightalarmID);

        morningalarmID.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                morningalarmID.setText("Thank You");
                Intent intent = new Intent(MainActivity3.this,MorningAlarmActivity.class);
                startActivity(intent);

            }
        });

        noonalarmID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
noonalarmID.setText("Thank you");
                Intent intent = new Intent(MainActivity3.this,NoonAlarmActivity.class);
                startActivity(intent);
            }
        });

        nightalarmID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nightalarmID.setText("Thank you");
                Intent intent = new Intent(MainActivity3.this,NightAlarmActivity.class);
                startActivity(intent);
            }
        });

    }
}
