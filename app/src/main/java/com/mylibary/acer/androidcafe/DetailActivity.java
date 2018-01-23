package com.mylibary.acer.androidcafe;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ACER on 1/22/2018.
 */

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Retrive the data coming from MainActivity.java
        Menu menu = getIntent().getParcelableExtra("menu");

// Pass the data to DetailFragmentB.java to display it
FragmentManager fragmentManager = getFragmentManager();
FragmentDetail detailFragment = (FragmentDetail)
        fragmentManager.findFragmentById(R.id.fragmentD);
detailFragment.displayData(menu);
    }

    }
