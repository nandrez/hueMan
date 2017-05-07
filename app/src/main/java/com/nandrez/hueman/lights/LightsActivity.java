/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nandrez.hueman.R;
import com.nandrez.hueman.util.HueActivities;

public class LightsActivity extends AppCompatActivity {
    
    private LightsPresenter presenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);
    
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    
        LightsFragment fragment = getLightsFragment();
        presenter = new LightsPresenter(fragment);
    }
    
    private LightsFragment getLightsFragment() {
        LightsFragment fragment = (LightsFragment) getFragmentManager().findFragmentById(R.id.contentFragment);
        if (fragment == null) {
            fragment = new LightsFragment();
            HueActivities.addFragment(getFragmentManager(), fragment, 0);
        }
        return fragment;
    }
    
}