/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nandrez.hueman.R;
import com.nandrez.hueman.data.Dimmable;
import com.nandrez.hueman.data.Hueable;
import com.nandrez.hueman.data.Illuminable;
import com.nandrez.hueman.view.adapters.IlluminablesAdapter;
import com.nandrez.hueman.view.model.Light;

public class LightsFragment extends Fragment implements LightsContract.View {
    
    private LightsContract.Presenter presenter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private IlluminablesAdapter illuminablesAdapter;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        illuminablesAdapter = new IlluminablesAdapter();
        layoutManager = new LinearLayoutManager(getContext());
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lights, container, false);
    
        List<Illuminable> sampleIlluminables = createSampleIlluminables(8);
        showIlluminables(sampleIlluminables);
        
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(illuminablesAdapter);
        
        return root;
    }
    
    private List<Illuminable> createSampleIlluminables(int amount) {
        List illuminables = new ArrayList(amount);
        for (int i = 1; i <= amount; i++) {
            Light light = new Light();
            light.setName("Light " + i);
            light.setHue(Hueable.MAX_HUE);
            light.setSaturation(Hueable.MAX_SATURATION);
            light.setBrightness(Dimmable.MAX_BRIGHTNESS / 2);
            illuminables.add(light);
        }
        return illuminables;
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
    public LightsContract.Presenter getPresenter() {
        return presenter;
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
    public void showIlluminables(List<Illuminable> illuminables) {
        illuminablesAdapter.replaceIlluminables(illuminables);
    }
    
}
