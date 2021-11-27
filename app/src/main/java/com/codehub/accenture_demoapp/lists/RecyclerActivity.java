package com.codehub.accenture_demoapp.lists;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.codehub.accenture_demoapp.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity implements RecyclerCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        List<String> arrayData = new ArrayList<>();
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");
        arrayData.add("Vassilis");
        arrayData.add("Markos");
        arrayData.add("Orfeas");
        arrayData.add("Maria");


        RecyclerAdapter adapter = new RecyclerAdapter(arrayData,this);

        recyclerView.setAdapter(adapter);
    }

    private Boolean isClicked = false;

    @Override
    public void onItemClicked(View view, String data) {
        Log.d("Adapter", "clicked with data -> " + data);

        if (isClicked == false) {
            isClicked = true;
            Snackbar.make(view, "Clicked " + data, Snackbar.LENGTH_LONG).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                @Override
                public void onDismissed(Snackbar transientBottomBar, int event) {
                    super.onDismissed(transientBottomBar, event);
                    isClicked = false;
                    Log.d("Adapter", "dismissed");

                }
            }).show();
        } else {
            Log.d("Adapter", "ignore");
        }
    }
}