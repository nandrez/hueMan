/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui.components.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nandrez.hueman.R;

public class LightSwitchFragment extends TabFragment {
    
    public LightSwitchFragment(String tabTitle) {
        super(tabTitle);
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflateTabView(inflater, R.layout.fragment_light_switch, container);
    }
    
}
