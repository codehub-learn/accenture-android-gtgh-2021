package com.codehub.accenture_demoapp.ui.tv;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.codehub.accenture_demoapp.R;

public class ProgramListActivity extends AppCompatActivity {

    @Nullable
    private ProgramListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_list);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ProgramListViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.program_list_list);
        viewModel.observeToStreamAdapter(this, new Observer<RecyclerView.Adapter>() {
            @Override
            public void onChanged(RecyclerView.Adapter adapter) {
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (viewModel != null) {
            viewModel.fetchDataFromServer();
        }
    }

    @Override
    protected void onStop() {
        if (viewModel != null) {
            viewModel.disableStreams(this);
        }
        super.onStop();
    }
}