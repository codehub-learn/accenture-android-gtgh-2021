package com.codehub.accenture_demoapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(DatabaseTable table);

    @Delete
    public void delete(DatabaseTable table);

//    @Update
//    public void update(DatabaseTable table);

    @Query("SELECT * FROM Users")
    public List<DatabaseTable> queryGetAll();

    @Query("SELECT * FROM Users LIMIT 1")
    public DatabaseTable queryGetFirst();

    @Query("SELECT * FROM Users WHERE userName LIKE :username")
    public List<DatabaseTable> queryGetWhere(String username);
}
