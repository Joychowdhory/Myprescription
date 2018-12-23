package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button morningbuttonID;
    private Button noonbuttonID;
    private Button nightbuttonID;
    private TextView textviewID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewID = (TextView) findViewById(R.id.textviewID);
        morningbuttonID = (Button) findViewById(R.id.morningbuttonID);
        noonbuttonID = (Button) findViewById(R.id.noonbuttonID);
        nightbuttonID = (Button) findViewById(R.id.nightbuttonID);

        morningbuttonID.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                morningbuttonID.setText("Thank You");
                Intent intent = new Intent(MainActivity.this,MorningAddActivity.class);
                startActivity(intent);

            }
        });
        noonbuttonID.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                noonbuttonID.setText("Thank You 2");
                Intent intent = new Intent(MainActivity.this,NoonAddActivity.class);
                startActivity(intent);

            }
        });

        nightbuttonID.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                nightbuttonID.setText("Thank You 3");
                Intent intent = new Intent(MainActivity.this,NightAddActivity.class);
                startActivity(intent);

            }
        });
    }

}


