/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.components;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class TabFragment extends Fragment {
    
    private String title;
    
    protected static View inflateTabView(LayoutInflater inflater, int resourceId, @Nullable ViewGroup container) {
        return inflater.inflate(resourceId, container, false);
    }
    
    public String getTabTitle() {
        if (title == null) {
            title = "";
        }
        return title;
    }
    
    public void setTabTitle(String tabTitle) {
        title = tabTitle;
    }
    
}
