package com.example.joychowdhory.homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper2 extends SQLiteOpenHelper  {

    private static final String TAGGG = "DatabaseHelper2";

    private static final String TABLE_NAMEEE = "noon_medicine";
    private static final String COL5 = "ID";
    private static final String COL6 = "name";

    public DatabaseHelper2(Context context) {
        super(context, TABLE_NAMEEE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAMEEE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL6 +" TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF  TABLE EXISTS " + TABLE_NAMEEE);
        onCreate(db);
    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL6, item);

        Log.d(TAGGG, "addData: Adding " + item + " to " + TABLE_NAMEEE);
        long result = db.insert(TABLE_NAMEEE, null, contentValues);

        //if data is entered incorrectly it will return -1
        if (result == -1){
            return false;
        } else {
            return true;

        }

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAMEEE;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    //Returns only the id that matches the name passed in
    // name
    //return
    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL5 + " FROM " + TABLE_NAMEEE +
                " WHERE " + COL6 + " = '" + name + "'";
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
        String query = "UPDATE " + TABLE_NAMEEE + " SET " + COL6 +
                " = '" + newName + "' WHERE " + COL5 + " = '" + id + "'" +
                " AND " + COL6 + " = '" + oldName + "'";
        Log.d(TAGGG, "updateName: query: " + query);
        Log.d(TAGGG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    // Delete from database
    //id
    //name
    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAMEEE + " WHERE "
                + COL5 + " = '" + id + "'" +
                " AND " + COL6 + " = '" + name + "'";
        Log.d(TAGGG, "deleteName: query: " + query);
        Log.d(TAGGG, "deleteName: Deleting " + name + "from database.");
        db.execSQL(query);

    }

}

