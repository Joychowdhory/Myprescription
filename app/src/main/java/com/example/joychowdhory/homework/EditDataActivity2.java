package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDataActivity2 extends AppCompatActivity {
    private static final String TAG = "EditDataActivity2";

    private Button deletebuttonID2,savebuttonID2;
    private EditText edittext2ID2;

    DatabaseHelper2 mDatabaseHelper;

    private String selectedName;
    private int selectedID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data2);


        edittext2ID2 = (EditText) findViewById(R.id.edittext2ID2);
        deletebuttonID2 = (Button) findViewById(R.id.deletebuttonID2);
        savebuttonID2 = (Button) findViewById(R.id.savebuttonID2);
        mDatabaseHelper = new DatabaseHelper2(this);

        // get the intent extra from the ListViewActivity
        Intent receivedIntent = getIntent();

        // now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value

        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("name");

        //set the text to show the current selected name
        edittext2ID2.setText(selectedName);

        savebuttonID2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String item = edittext2ID2.getText().toString();
                if( !item.equals("")){
                    mDatabaseHelper.updateName(item,selectedID,selectedName);
                }else {
                    toastMessage("You must enter your name");
                }
            }
        });
        deletebuttonID2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mDatabaseHelper.deleteName(selectedID,selectedName);
                edittext2ID2.setText("");
                toastMessage("removed from database");
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();
    }

}
