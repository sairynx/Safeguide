package com.example.safeguide1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SGDB.db";
    private static final int DATABASE_VERSION = 1;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your database tables here
        db.execSQL("CREATE TABLE DisasterTable (earthquakemodules TEXT PRIMARY KEY," + "tsunamimodules TEXT,"+"tropicalstormsmodules TEXT,"+"stormsurgemodules TEXT,"
                +"thunderstromsmodules TEXT,"+ "floodingmodules TEXT,"+"firemodules TEXT," + "Terrorismmodules TEXT)");
        String[] earthquakemodules = new String[] {
                "Dangers Associated with Earthquakes","Earthquake Safety Guidelines","After an Earthquake"};
        String[] tsunamimodules = new String[]{
                ""
        };

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade logic here
        db.execSQL("DROP TABLE IF EXISTS earthquake");
        onCreate(db);
    }

    // Method to insert data into the database
    public long insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        long newRowId = db.insert("earthquake", null, values);
        db.close();
        return newRowId;
    }


}
