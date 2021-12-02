package com.codehub.accenture_demoapp.vvmv;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.codehub.accenture_demoapp.R;

public class MVVMActivity extends AppCompatActivity {

    @Nullable
    private BaseAndroidViewModel androidViewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvmactivity);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        BaseViewModelClass viewmodel = new ViewModelProvider(this).get(BaseViewModelClass.class);
        androidViewmodel = new ViewModelProvider(this).get(BaseAndroidViewModel.class);
        androidViewmodel.listenToStream(this, new Observer<String>() {
            @Override
            public void onChanged(String string) {
                Log.d("TAG", string);
            }
        });
    }

    @Override
    protected void onStop() {
        if (androidViewmodel != null) {
            androidViewmodel.removeFromStream(this);
        }
        super.onStop();


    }
}