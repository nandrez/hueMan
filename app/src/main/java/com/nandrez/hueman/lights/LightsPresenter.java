/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import com.nandrez.hueman.data.LightSource;

public class LightsPresenter implements LightsContract.Presenter {
    
    private final LightsContract.View view;
    private boolean isInitialized;
    
    LightsPresenter(LightsContract.View lightsView) {
        view = lightsView;
        view.setPresenter(this);
    }
    
    @Override
    public void start() {
        loadLightSources(true);
    }
    
    @Override
    public void result(int requestCode, int resultCode) {
        
    }
    
    @Override
    public void loadLightSources(boolean forceReload) {
        loadLightSources(!isInitialized || forceReload, true);
        isInitialized = true;
    }
    
    private void loadLightSources(boolean forceReload, boolean showIndicator) {
        if (showIndicator) {
            view.displayLoadingIndicator(true);
        }
    }
    
    @Override
    public void addNewLightSource() {
        
    }
    
    @Override
    public void turnOnLightSources(LightSource... lightsource) {
        
    }
    
    @Override
    public void turnOffLightSources(LightSource... lightsource) {
        
    }
    
    @Override
    public void dimLightSources(float brightness, LightSource... lightSource) {
        
    }
    
    @Override
    public void hueLightSources(float hue, LightSource... lightSource) {
        
    }
    
    @Override
    public void saturateLightSources(float saturation, LightSource... lightSource) {
        
    }
    
}