package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MorningAddActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    private Button addbuttonID,viewdatabuttonID;
    private EditText edittextID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning_add);


        edittextID = (EditText) findViewById(R.id.edittextID);
        addbuttonID = (Button) findViewById(R.id.addbuttonID);
        viewdatabuttonID = (Button) findViewById(R.id.viewdatabuttonID);
        mDatabaseHelper = new DatabaseHelper(this);

        addbuttonID.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String newEntry = edittextID.getText().toString();
                if (edittextID.length() != 0){
                    AddData(newEntry);
                    edittextID.setText("");
                } else {
                    toastMessage("Please Add Your Medicine");
                }

            }
        });

        viewdatabuttonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MorningAddActivity.this,ListDataActivity.class);
                startActivity(intent);
            }
        });

    }
    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if (insertData){
            toastMessage("Data Sucessfully inserted");
        } else {
            toastMessage("Something Wrong");
        }

    }


    private void toastMessage(String message){
        Toast.makeText(this,"message",Toast.LENGTH_SHORT).show();
    }

}


