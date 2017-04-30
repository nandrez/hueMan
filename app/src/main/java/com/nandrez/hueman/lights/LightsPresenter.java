/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import com.nandrez.hueman.data.LightSource;

public class LightsPresenter implements LightsContract.Presenter {
    
    private final LightsContract.View view;
    
    public LightsPresenter(LightsContract.View lightsView) {
        this.view = lightsView;
    }
    
    @Override
    public void start() {
        
    }
    
    @Override
    public void loadLightSources(boolean forceReload) {
        
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
