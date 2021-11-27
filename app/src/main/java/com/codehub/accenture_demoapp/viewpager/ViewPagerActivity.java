package com.codehub.accenture_demoapp.viewpager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.codehub.accenture_demoapp.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        List<Fragment> arrayData = new ArrayList<>();
        arrayData.add(new PagerFragment());
        arrayData.add(new PagerFragment());
        arrayData.add(new PagerFragment());
        arrayData.add(new PagerFragment());
        arrayData.add(new PagerFragment());

        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), arrayData));

        Button btnBack = findViewById(R.id.button_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = pager.getCurrentItem();
                pager.setCurrentItem(currentPosition - 1, true);
            }
        });

        Button btnNext = findViewById(R.id.button_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = pager.getCurrentItem();
                pager.setCurrentItem(currentPosition + 1, true);
            }
        });

        Button btnSheet = findViewById(R.id.button_sheet);
        btnSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemListDialogFragment dialogFragment = new ItemListDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "ItemListDialogFragment-Modal");
            }
        });

    }
}