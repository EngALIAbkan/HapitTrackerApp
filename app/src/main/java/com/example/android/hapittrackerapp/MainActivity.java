package com.example.android.hapittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.hapittrackerapp.Data.HabitContract;
import com.example.android.hapittrackerapp.Data.HapitDBHelper;

public class MainActivity extends AppCompatActivity {
    HapitDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new HapitDBHelper(MainActivity.this);
        insertHabit("walking", 2);

    }

    public  Cursor fetchdata() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(HabitContract.HabitEntry.HABIT_TABLE_NAME,null,null,null,null,null,null);
        return cursor;
    }
    public void insertHabit(String name, int time) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_NAME_HABIT_NAME, name);
        values.put(HabitContract.HabitEntry.COLUMN_NAME_HABIT_TIME, time);
        Long RowId = db.insert(HabitContract.HabitEntry.HABIT_TABLE_NAME, null, values);
        if (RowId == -1) {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "good", Toast.LENGTH_LONG).show();

        }

    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}
