package com.example.fishnclick;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String TABLE_FISH ="FISH";

    private static final String COLUMN_FISH_ID ="Fish_Id";
    private static final String COLUMN_FISH_CLICKS ="Fish_Clicks";
    private static final String COLUMN_FISH_ENABLED ="Fish_Enabled";
    private static final String COLUMN_FISH_LEVEL ="Fish_Level";
    private static final String DATABASE_NAME = "FISHNCLICK";
    private static final int DATABASE_VERSION = 1;
    private ArrayList<Fish> fishList;
    public MyDatabase(Context context, ArrayList<Fish> fishList) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.fishList=fishList;
;
    }
    public MyDatabase(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLScript = "CREATE TABLE " + TABLE_FISH + "("
                +COLUMN_FISH_ID + " STRING PRIMARY KEY, "
                +COLUMN_FISH_CLICKS + " INTEGER NOT NULL, "
                +COLUMN_FISH_ENABLED + " BOOLEAN NOT NULL, "
                +COLUMN_FISH_LEVEL + " INTEGER NOT NULL"+")";
        db.execSQL(SQLScript);
        for (Fish f:fishList) {
            String SQLAddFish = "INSERT INTO " + TABLE_FISH + "("+COLUMN_FISH_ID+","+COLUMN_FISH_ENABLED+","+COLUMN_FISH_CLICKS+","+COLUMN_FISH_LEVEL+")"
                    +"VALUES("+"'"+f.toString()+"'"+","+f.getEnabled()+","+f.getClicks()+","+f.getLevel()+")";
            db.execSQL(SQLAddFish);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
    }

    public void updateFish(Fish fish) {
        int enabled = fish.getEnabled() ? 1 : 0;
        String strSQL = "UPDATE " + TABLE_FISH
                +" SET " + COLUMN_FISH_LEVEL + " = " + fish.getLevel() + ","
                + COLUMN_FISH_CLICKS + " = " + fish.getClicks() + ","
                + COLUMN_FISH_ENABLED + " = " + fish.getEnabled()  +
                " WHERE " + COLUMN_FISH_ID + " = " +"'"+fish.toString()+"'";
        this.getWritableDatabase().execSQL(strSQL);
        this.getWritableDatabase().close();
    }
    public void updateFishList(ArrayList<Fish> fishList) {
        String sqlGETALL = "SELECT * FROM " + TABLE_FISH;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sqlGETALL,null);

        if(cursor.moveToFirst()) {
            do {
                String fishName = cursor.getString(0);
                int FishClicks = cursor.getInt(1);
                boolean fishEnabled = cursor.getInt(2) == 1 ? true:false;
                int Fishlvl = cursor.getInt(3);
                for (Fish f:fishList) {
                    if(f.toString().equals(fishName)) {
                        f.setEnabled(fishEnabled);
                        f.setLevel(Fishlvl);
                        f.setClicks(FishClicks);
                    }
                }
            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }
}
