package com.codehub.accenture_demoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeFragment extends AbstractFragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public static HomeFragment newInstance(String name) {
        HomeFragment fragment = new HomeFragment();
        Bundle parameters = new Bundle();
        parameters.putString("name", name);
        parameters.putInt("age", 100);
        fragment.setArguments(parameters);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void startOperations(View view) {
        String name = getArguments().getString("name");

        TextView textView = view.findViewById(R.id.home_fragment_text);
        textView.setText(name);

    }

    @Override
    public void stopOperations() {

    }
}