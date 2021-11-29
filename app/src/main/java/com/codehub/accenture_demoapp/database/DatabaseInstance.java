package com.codehub.accenture_demoapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DatabaseTable.class}, version = 1)
public abstract class DatabaseInstance extends RoomDatabase {
    public abstract DatabaseDao getDatabaseTableDao();
}
