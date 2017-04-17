/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.nandrez.hueman.R;
import com.nandrez.hueman.ui.components.TabFragmentAdapter;
import com.nandrez.hueman.ui.lights.LightsFragment;
import com.nandrez.hueman.ui.scenes.ScenesFragment;
import com.nandrez.hueman.ui.components.TabFragment;

public class HueManActivity extends Activity {
    
    private TabFragmentAdapter tabFragmentAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hueman);
        
        initTabLayout();
    }
    
    private void initTabLayout() {
        tabFragmentAdapter = new TabFragmentAdapter(getFragmentManager());
        tabFragmentAdapter.addItem(new LightsFragment(getString(R.string.title_fragment_lights)));
        tabFragmentAdapter.addItem(new ScenesFragment(getString(R.string.title_fragment_scenes)));
        
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(tabFragmentAdapter);
        
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}
