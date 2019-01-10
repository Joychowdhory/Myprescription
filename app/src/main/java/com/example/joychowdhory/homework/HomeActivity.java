package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {
    private Button medicinebuttonID;
    private Button appointbuttonID;
    private Button alarmbuttonID;
    private Button hospitalID;
    private Button symptommbuttonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        medicinebuttonID = (Button) findViewById(R.id.medicinebuttonID);
        appointbuttonID = (Button) findViewById(R.id.appointbuttonID);
        alarmbuttonID = (Button) findViewById(R.id.alarmbuttonID);
        hospitalID = (Button) findViewById(R.id.hospitalID);
        symptommbuttonID = (Button) findViewById(R.id.symptommbuttonID);


        medicinebuttonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        appointbuttonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =new Intent(HomeActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        alarmbuttonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(HomeActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        symptommbuttonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MainActivity4.class);
                startActivity(intent);
            }
        });

    }



}

