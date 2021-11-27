package com.codehub.accenture_demoapp.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> array = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm, List<Fragment> array) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT);
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return array.get(position);
    }
}
