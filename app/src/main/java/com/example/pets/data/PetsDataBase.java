package com.example.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pets.EditPetActivity;

public class PetsDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "pets.db";
    public static final int DATABASE_VERSION = 1;

    public PetsDataBase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetsContract.PetsEntry.TABLE_NAME + " ("
                + PetsContract.PetsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetsContract.PetsEntry.COLUMN_PETS_NAME + " TEXT NOT NULL, "
                + PetsContract.PetsEntry.COLUMN_PETS_BREED + " TEXT, "
                + PetsContract.PetsEntry.COLUMN_PETS_GENDER + " INTEGER NOT NULL, "
                + PetsContract.PetsEntry.COLUMN_PETS_WEIGHT + " INTEGER NOT NULL DEFAULT 0, "
                + PetsContract.PetsEntry.COLUMN_PETS_HEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_ENTRIES = "DROP TABLE " + PetsContract.PetsEntry.TABLE_NAME + " ;";
        db.execSQL(SQL_DELETE_ENTRIES);
    }
}
