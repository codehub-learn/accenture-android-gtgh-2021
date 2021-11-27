package com.codehub.accenture_demoapp.preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codehub.accenture_demoapp.R;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        TextView textView = findViewById(R.id.preferences_title);

        SharedPreferences preferences = this.getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        SharedPreferences localPreferences = this.getPreferences(MODE_PRIVATE);

        String name = localPreferences.getString("name", "Empty");
        textView.setText(name);

        Button btnLive = findViewById(R.id.preferences_btn_live);
        btnLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences localPreferences = PreferencesActivity.this.getPreferences(MODE_PRIVATE);
                localPreferences.edit().putString("name", "Live Update").commit();

                String name = localPreferences.getString("name", "Empty");
                textView.setText(name);
            }
        });
        Button btnAsync = findViewById(R.id.preferences_btn_async);
        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences localPreferences = PreferencesActivity.this.getPreferences(MODE_PRIVATE);

                SharedPreferences.Editor editor = localPreferences.edit();
                editor.putString("name", getString(R.string.long_text));
                editor.apply();

                String name = localPreferences.getString("name", "Empty");
                textView.setText(name);
            }
        });
    }
}