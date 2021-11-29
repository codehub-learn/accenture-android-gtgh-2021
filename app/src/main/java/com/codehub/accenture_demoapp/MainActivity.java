package com.codehub.accenture_demoapp;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AbsActivity {

    @Override
    public int getLayoutRes() {
        return R.layout.layout_constraint_login;
    }

    @Override
    public void startOperations() {

        getApplicationContext().getResources().getStringArray(R.array.menu);

        ImageView backButton = findViewById(R.id.login_back_btn);
        Button bthLogin = findViewById(R.id.login_btn_login);
        TextView forgotPass = findViewById(R.id.login_forgot);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        bthLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("name", "Pigadas Vassilis");
                startActivityForResult(intent, 2000);
            }
        });

        bthLogin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v, "Not implemented yet!", Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Not implemented yet!", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void stopOperations() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2000) {
            if (resultCode == Activity.RESULT_OK) {
                String property = data.getExtras().getString("result");
                Log.d("ACTIVITY_RESULT", "OK");
            }else if(resultCode == Activity.RESULT_CANCELED){
                Log.d("ACTIVITY_RESULT", "CANCEL");
            } else {
                Log.d("ACTIVITY_RESULT", "PROBLEM");
            }
        }
    }
}