package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDataActivity1 extends AppCompatActivity {


    private static final String TAG = "EditDataActivity1";

    private Button deletebuttonID1,savebuttonID1;
    private EditText edittext2ID1;

    DatabaseHelper1 mDatabaseHelper;

    private String selectedName;
    private int selectedID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data1);


        edittext2ID1 = (EditText) findViewById(R.id.edittext2ID1);
        deletebuttonID1 = (Button) findViewById(R.id.deletebuttonID1);
        savebuttonID1 = (Button) findViewById(R.id.savebuttonID1);
        mDatabaseHelper = new DatabaseHelper1(this);

        // get the intent extra from the ListViewActivity
        Intent receivedIntent = getIntent();

        // now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value

        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("name");

        //set the text to show the current selected name
        edittext2ID1.setText(selectedName);

        savebuttonID1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String item = edittext2ID1.getText().toString();
                if( !item.equals("")){
                    mDatabaseHelper.updateName(item,selectedID,selectedName);
                }else {
                    toastMessage("You must enter your name");
                }
            }
        });
        deletebuttonID1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mDatabaseHelper.deleteName(selectedID,selectedName);
                edittext2ID1.setText("");
                toastMessage("removed from database");
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();
    }

}
