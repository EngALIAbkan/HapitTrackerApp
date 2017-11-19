package com.example.android.hapittrackerapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.attr.version;


public class HapitDBHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "habit.db";
    private final static int DATABASE_VERSION = 1;
    public HapitDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateMealTabel = "CREATE TABlE " +
                HabitContract.HabitEntry.HABIT_TABLE_NAME +
                "("+ HabitContract.HabitEntry.COLUMN_NAME_HABIT_ID + " INTEGER PRIMARY KEY," +
                HabitContract.HabitEntry.COLUMN_NAME_HABIT_NAME + " TEXT," +
                HabitContract.HabitEntry.COLUMN_NAME_HABIT_TIME + " INTEGER);";
        db.execSQL(CreateMealTabel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DropMealTable = "DROP TABLE IF EXISTS" + HabitContract.HabitEntry.HABIT_TABLE_NAME + ";";
        db.execSQL(DropMealTable);

    }
}
