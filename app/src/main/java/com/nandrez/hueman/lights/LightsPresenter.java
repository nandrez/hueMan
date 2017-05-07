/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import com.nandrez.hueman.data.Dimmable;
import com.nandrez.hueman.data.Hueable;

public class LightsPresenter implements LightsContract.Presenter {
    
    private final LightsContract.View view;
    private boolean isInitialized;
    
    LightsPresenter(LightsContract.View lightsView) {
        view = lightsView;
        view.setPresenter(this);
    }
    
    @Override
    public void start() {
        loadIlluminables(true);
    }
    
    @Override
    public void result(int requestCode, int resultCode) {
        
    }
    
    @Override
    public void loadIlluminables(boolean forceReload) {
        loadLightSources(!isInitialized || forceReload, true);
        isInitialized = true;
    }
    
    private void loadLightSources(boolean forceReload, boolean showIndicator) {
        if (showIndicator) {
            view.displayLoadingIndicator(true);
        }
    }
    
    @Override
    public void addNewIlluminable() {
        
    }
    
    @Override
    public void turnOnIlluminables(Dimmable... dimmables) {
        
    }
    
    @Override
    public void turnOffIlluminables(Dimmable... dimmables) {
        
    }
    
    @Override
    public void dimIlluminables(float brightness, Dimmable... dimmables) {
        
    }
    
    @Override
    public void hueIlluminables(float hue, Hueable... hueables) {
        
    }
    
    @Override
    public void saturateIlluminables(float saturation, Hueable... hueables) {
        
    }
}