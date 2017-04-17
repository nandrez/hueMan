/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui.components;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nandrez.hueman.R;

public abstract class TabFragment extends Fragment {
    
    private final String title;
    
    public TabFragment(String tabTitle) {
        title = tabTitle;
    }
    
    public static View inflateTabView(LayoutInflater inflater, int resourceId, @Nullable ViewGroup container) {
        return inflater.inflate(resourceId, container, false);
    }
    
    public String getTabTitle() {
        return title;
    }
    
}
