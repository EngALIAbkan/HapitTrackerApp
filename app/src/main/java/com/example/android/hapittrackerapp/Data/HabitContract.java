package com.example.android.hapittrackerapp.Data;

import android.provider.BaseColumns;

public class HabitContract  {

    public final static class HabitEntry implements BaseColumns {

        public final static String HABIT_TABLE_NAME = "habit";
        public final static String COLUMN_NAME_HABIT_ID = BaseColumns._ID;
        public final static String COLUMN_NAME_HABIT_NAME = "name";
        public final static String COLUMN_NAME_HABIT_TIME = "time";
    }
}
