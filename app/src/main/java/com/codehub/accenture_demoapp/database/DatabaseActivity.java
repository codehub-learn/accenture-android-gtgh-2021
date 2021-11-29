package com.codehub.accenture_demoapp.database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.codehub.accenture_demoapp.R;

import java.util.List;
import java.util.UUID;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Button button = findViewById(R.id.database_insert);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseTable table = new DatabaseTable(UUID.randomUUID().hashCode());
                table.setActive(true);
                table.setName("Vassilis");
                table.setAge(30);

                DatabaseInstance databaseInstance = Room.databaseBuilder(DatabaseActivity.this,
                        DatabaseInstance.class, "myDatabase").build();

                new AsyncTaskWriteOperation(databaseInstance, new AsyncTaskWriteOperation.Listener() {
                    @Override
                    public void getResponse(Boolean list) {
                        Log.d("Database", "Result -> " + list);

                        if (list) {
                            refresh();
                        }
                    }
                }).execute(table);
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        refresh();
    }

    private void refresh() {
        DatabaseInstance databaseInstance = Room.databaseBuilder(this, DatabaseInstance.class, "myDatabase").build();

        new AsyncTaskOperation(databaseInstance, new AsyncTaskOperation.Listener() {
            @Override
            public void getResponse(List<DatabaseTable> list) {
                for (DatabaseTable item : list) {
                    Log.d("Database", item.toString());
                }
            }
        }).execute();
    }
}