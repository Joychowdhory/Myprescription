package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {


    private Button medicinebuttonID;
    private Button appointbuttonID;
    private Button alarmbuttonID;
    private Button hospitalID;
    private Button symptommbuttonID;

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView nav_view;

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



        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nav_view =(NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.quote)
                {
                    Toast.makeText(HomeActivity.this, "Quote",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent (HomeActivity.this,MainActivity11.class);
//                    startActivity(intent);

                }
                else if(id == R.id.map)
                {
                    Toast.makeText(HomeActivity.this, "Map",Toast.LENGTH_SHORT).show();

                }
                else if(id == R.id.setting)
                {
                    Toast.makeText(HomeActivity.this, "setting",Toast.LENGTH_SHORT).show();

                }
                else if(id == R.id.about)
                {
                    Toast.makeText(HomeActivity.this, "about us",Toast.LENGTH_SHORT).show();

                }


                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}