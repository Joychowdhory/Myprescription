package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NightAddActivity extends AppCompatActivity {

    DatabaseHelper2 mDatabaseHelper;
    private Button addbuttonID2,viewdatabuttonID2;
    private EditText edittextID2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_add);



        edittextID2 = (EditText) findViewById(R.id.edittextID2);
        addbuttonID2 = (Button) findViewById(R.id.addbuttonID2);
        viewdatabuttonID2 = (Button) findViewById(R.id.viewdatabuttonID2);
        mDatabaseHelper = new DatabaseHelper2(this);

        addbuttonID2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String newEntry = edittextID2.getText().toString();
                if (edittextID2.length() != 0){
                    AddData(newEntry);
                    edittextID2.setText("");
                } else {
                    toastMessage("Please Add Your Medicine");
                }

            }
        });

        viewdatabuttonID2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NightAddActivity.this,ListDataActivity2.class);
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

