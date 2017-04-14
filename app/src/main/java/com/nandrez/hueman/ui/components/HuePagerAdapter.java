/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui.components;

import java.util.ArrayList;
import java.util.List;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.support.v13.app.FragmentPagerAdapter;

import com.nandrez.hueman.R;
import com.nandrez.hueman.ui.components.tabs.LightSwitchFragment;
import com.nandrez.hueman.ui.components.tabs.SceneFragment;
import com.nandrez.hueman.ui.components.tabs.TabFragment;

public class HuePagerAdapter extends FragmentPagerAdapter {
    
    private final List<TabFragment> tabs;
    
    public HuePagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        tabs = new ArrayList<>();
        Resources resources = context.getResources();
        tabs.add(new LightSwitchFragment(resources.getString(R.string.title_fragment_lightswitch)));
        tabs.add(new SceneFragment(resources.getString(R.string.title_fragment_scene)));
    }
    
    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTabTitle();
    }
    
    @Override
    public int getCount() {
        return tabs.size();
    }
    
}