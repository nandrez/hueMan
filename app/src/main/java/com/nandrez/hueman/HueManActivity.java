/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.nandrez.hueman.lights.LightsFragment;
import com.nandrez.hueman.lights.LightsPresenter;
import com.nandrez.hueman.scenes.ScenesFragment;
import com.nandrez.hueman.view.adapters.TabFragmentAdapter;

public class HueManActivity extends Activity {
    
    private TabFragmentAdapter tabFragmentAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hueman);
        
        initTabs();
    }
    
    private void initTabs() {
        tabFragmentAdapter = new TabFragmentAdapter(getFragmentManager());
        
        LightsFragment lightsTab = new LightsFragment();
        tabFragmentAdapter.addItem(lightsTab, getString(R.string.title_fragment_lights));
        ScenesFragment scenesTab = new ScenesFragment();
        tabFragmentAdapter.addItem(scenesTab, getString(R.string.title_fragment_scenes));
    
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(tabFragmentAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}
