/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.nandrez.hueman.R;
import com.nandrez.hueman.util.HueActivities;

public class LightsActivity extends Activity {
    
    private LightsPresenter presenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);
    
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);
    
        LightsFragment fragment = getLightsFragment();
        presenter = new LightsPresenter(fragment);
    }
    
    private LightsFragment getLightsFragment() {
        LightsFragment fragment = (LightsFragment) getFragmentManager().findFragmentById(0);
        if (fragment == null) {
            fragment = new LightsFragment();
            HueActivities.addFragment(getFragmentManager(), fragment, 0);
        }
        return fragment;
    }
    
}