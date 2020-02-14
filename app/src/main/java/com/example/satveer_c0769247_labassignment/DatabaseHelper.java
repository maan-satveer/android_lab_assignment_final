package com.example.satveer_c0769247_labassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FavouritePlaces";

    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "places";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_NAME = "nameoffavrtplace";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_DATE = "date";

    public DatabaseHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " varchar(200),"+
                COLUMN_ADDRESS + " varchar(200) , " +
                COLUMN_DATE + " varchar(200) NOT NULL," +
                COLUMN_LATITUDE + " double NOT NULL, " +
                COLUMN_LONGITUDE + " double NOT NULL);";


        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(sql);
        onCreate(db);
    }

    boolean addFavrtPlaces( String nameoffavrtplace,String date,String address, double latitude, double longitude) {

        //inorder to insert ,we need writable database;
        //this method returns a sqlite instance;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        //contain value object
        ContentValues cv = new ContentValues();
        //this first argument of the put method is the columnn name and second value

        cv.put(COLUMN_NAME,nameoffavrtplace);
        cv.put(COLUMN_ADDRESS,address);
        cv.put(COLUMN_LATITUDE,latitude);
        cv.put(COLUMN_LONGITUDE,longitude);
        cv.put(COLUMN_DATE,date);

        //insert returns value of row number and -1 is not successfull ;

        return  sqLiteDatabase.insert(TABLE_NAME,null,cv)!= 1;

    }

    Cursor getAllPlaces(){
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);

    }
    boolean updatePlaces(int id,String address, String nameoffavrtplace, double latitude, double longitude){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();
        //this first argument of the put method is the columnn name and second value


        cv.put(COLUMN_NAME,nameoffavrtplace);
        cv.put(COLUMN_ADDRESS,address);
        cv.put(COLUMN_LATITUDE,latitude);
        cv.put(COLUMN_LONGITUDE,longitude);



        //returns the affected num of rows;
        return  sqLiteDatabase.update(TABLE_NAME,cv,COLUMN_ID+" = ? ",new String[]{String.valueOf(id)}) >0 ;
    }

    boolean deletePlaces(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return  sqLiteDatabase.delete(TABLE_NAME,COLUMN_ID+" = ? ",new String[]{String.valueOf(id)}) >0;

    }



}