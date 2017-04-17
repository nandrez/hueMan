/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui.components;

import java.util.ArrayList;
import java.util.List;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class TabFragmentAdapter extends FragmentPagerAdapter {
    
    private final List<TabFragment> tabs;
    
    public TabFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        tabs = new ArrayList<>();
    }
    
    public void addItem(TabFragment tab) {
        tabs.add(tab);
    }
    
    @Override
    public TabFragment getItem(int position) {
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