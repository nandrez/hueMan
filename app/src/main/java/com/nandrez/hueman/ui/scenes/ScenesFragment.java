/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui.scenes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nandrez.hueman.R;
import com.nandrez.hueman.ui.components.TabFragment;

public class ScenesFragment extends TabFragment {
    
    public ScenesFragment(String tabTitle) {
        super(tabTitle);
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflateTabView(inflater, R.layout.fragment_scenes, container);
    }
    
}
