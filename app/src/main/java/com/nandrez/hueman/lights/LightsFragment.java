/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nandrez.hueman.R;
import com.nandrez.hueman.data.LightSource;
import com.nandrez.hueman.view.adapters.LightSourceAdapter;
import com.nandrez.hueman.view.components.TabFragment;

public class LightsFragment extends TabFragment implements LightsContract.View {
    
    private LightsContract.Presenter presenter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private LightSourceAdapter lightSourceAdapter;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lightSourceAdapter = new LightSourceAdapter();
        layoutManager = new LinearLayoutManager(getContext());
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lights, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(lightSourceAdapter);
        
        return root;
    }
    
    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.result(requestCode, resultCode);
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
    }
    
    @Override
    public void showLightSources(List<LightSource> lightSources) {
        lightSourceAdapter.replaceLightSources(lightSources);
    }
    
}
