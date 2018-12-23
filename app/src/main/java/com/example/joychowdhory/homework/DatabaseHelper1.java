package com.example.joychowdhory.homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper1 extends SQLiteOpenHelper {

    private static final String TAGG = "DatabaseHelper1";

    private static final String TABLE_NAMEE = "noon_medicine";
    private static final String COL3 = "ID";
    private static final String COL4 = "name";

    public DatabaseHelper1(Context context) {
        super(context, TABLE_NAMEE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAMEE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL4 +" TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF  TABLE EXISTS " + TABLE_NAMEE);
        onCreate(db);
    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4, item);

        Log.d(TAGG, "addData: Adding " + item + " to " + TABLE_NAMEE);
        long result = db.insert(TABLE_NAMEE, null, contentValues);

        //if data is entered incorrectly it will return -1
        if (result == -1){
            return false;
        } else {
            return true;

        }

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAMEE;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    //Returns only the id that matches the name passed in
    // name
    //return
    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL3 + " FROM " + TABLE_NAMEE +
                " WHERE " + COL4 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;

    }
    /** update the name field
     * Newname
     * id
     * old name
     * */
    public void updateName(String newName,int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAMEE + " SET " + COL4 +
                " = '" + newName + "' WHERE " + COL3 + " = '" + id + "'" +
                " AND " + COL4 + " = '" + oldName + "'";
        Log.d(TAGG, "updateName: query: " + query);
        Log.d(TAGG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    // Delete from database
    //id
    //name
    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAMEE + " WHERE "
                + COL3 + " = '" + id + "'" +
                " AND " + COL4 + " = '" + name + "'";
        Log.d(TAGG, "deleteName: query: " + query);
        Log.d(TAGG, "deleteName: Deleting " + name + "from database.");
        db.execSQL(query);

    }

}


