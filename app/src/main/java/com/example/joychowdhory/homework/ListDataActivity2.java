package com.example.joychowdhory.homework;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListDataActivity2 extends AppCompatActivity {

    private static final String TAGGG = "ListDataActivity2";

    DatabaseHelper2 mDatabaseHelper;
    private ListView listviewID2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data2);


        listviewID2 = (ListView) findViewById(R.id.listviewID2);
        mDatabaseHelper = new DatabaseHelper2(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(TAGGG, "populateListView: Displaying data in the ListView.");
        //get the data and open to the list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in col 1
            //then add it to the array list
            listData.add(data.getString(1));

        }
        //create the list adopter and set te adopter

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listviewID2.setAdapter(adapter);

        //set the item on clicklistener to thre list view

        listviewID2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAGGG, "onItemClick: You Clicked on " + name);

                Cursor data = mDatabaseHelper.getItemID(name);    //get the id associate with that name
                int itemID = -1;
                while (data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if (itemID > -1) {
                    Log.d(TAGGG, "onItemClick: The ID is: " + itemID);
                    Intent editScreenIntent = new Intent(ListDataActivity2.this,EditDataActivity1.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("name",name);
                    startActivity(editScreenIntent);
                }
                //Toast.makeText(ListDataActivity.this,"Item clicked ",Toast.LENGTH_LONG).show();
                else{
                    toastMessage("No id associate with that name");
                }
                Intent intent = new Intent(ListDataActivity2.this,EditDataActivity2.class);
                startActivity(intent);


            }
        });



    }
    //custom create toast
    private  void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
