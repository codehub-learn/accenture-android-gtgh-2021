package com.codehub.accenture_demoapp;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import retrofit2.Retrofit;

public class HomeActivity extends AbsActivity {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    public void startOperations() {
        String name = getIntent().getExtras().getString("name");

        TextView textView = findViewById(R.id.home_label);
        textView.setText(name);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result", "ÖLA KALA");
                setResult(Activity.RESULT_OK, intent);
                HomeActivity.this.finish();
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, HomeFragment.newInstance( "Pure Terror"));
        transaction.commit();
    }

    @Override
    public void stopOperations() { }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}