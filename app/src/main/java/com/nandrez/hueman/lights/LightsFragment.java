/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import java.util.List;
import android.content.Intent;
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
    
    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.result(requestCode, resultCode);
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflateTabView(inflater, R.layout.fragment_lights, container);
    }
    
    @Override
    public void setPresenter(LightsContract.Presenter lightsPresenter) {
        presenter = lightsPresenter;
    }
    
    @Override
    public void displayLoadingIndicator(final boolean shown) {
        if (getView() == null) {
            return;
        }
//        TODO: SwipeRefreshLayout
//        srl.post(new Runnable() {
//            @Override
//            public void run() {
//                srl.setRefreshing(shown);
//            }
//        });
    }
    
    @Override
    public void showLightSources(List<LightSource> lightSources) {
        
    }
    
}
