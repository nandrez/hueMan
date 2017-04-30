/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import java.util.List;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nandrez.hueman.R;
import com.nandrez.hueman.data.LightSource;
import com.nandrez.hueman.view.components.TabFragment;

public class LightsFragment extends TabFragment implements LightsContract.View {
    
    private LightsContract.Presenter presenter;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflateTabView(inflater, R.layout.fragment_lights, container);
    }
    
    @Override
    public void setPresenter(LightsContract.Presenter lightsPresenter) {
        presenter = lightsPresenter;
    }
    
    @Override
    public void showLightsources(List<LightSource> lightsources) {
        
    }
    
}
