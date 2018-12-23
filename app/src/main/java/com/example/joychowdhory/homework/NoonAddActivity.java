package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NoonAddActivity extends AppCompatActivity {
    DatabaseHelper1 mDatabaseHelper;
    private Button addbuttonID1,viewdatabuttonID1;
    private EditText edittextID1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noon_add);


        edittextID1 = (EditText) findViewById(R.id.edittextID1);
        addbuttonID1 = (Button) findViewById(R.id.addbuttonID1);
        viewdatabuttonID1 = (Button) findViewById(R.id.viewdatabuttonID1);
        mDatabaseHelper = new DatabaseHelper1(this);

        addbuttonID1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String newEntry = edittextID1.getText().toString();
                if (edittextID1.length() != 0){
                    AddData(newEntry);
                    edittextID1.setText("");
                } else {
                    toastMessage("Please Add Your Medicine");
                }

            }
        });

        viewdatabuttonID1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoonAddActivity.this,ListDataActivity1.class);
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

