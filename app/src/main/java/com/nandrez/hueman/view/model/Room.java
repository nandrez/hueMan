/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.model;

import java.util.ArrayList;
import java.util.List;

import com.nandrez.hueman.data.Dimmable;
import com.nandrez.hueman.data.Hueable;
import com.nandrez.hueman.data.LightSource;
import com.nandrez.hueman.util.LightSources;

public class Room implements Dimmable, Hueable {
    
    private List<LightSource> lightSources;
    
    public Room() {
        lightSources = new ArrayList<>();
    }
    
    @Override
    public boolean isOn() {
        for (LightSource light : lightSources) {
            if (light.isOn()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void on() {
        for (LightSource light : lightSources) {
            light.on();
        }
    }
    
    @Override
    public void off() {
        for (LightSource light : lightSources) {
            light.off();
        }
    }
    
    @Override
    public float getBrightness() {
        return LightSources.getAverageBrightness(lightSources);
    }
    
    @Override
    public void setBrightness(float brightness) {
        for (LightSource light : lightSources) {
            light.setBrightness(brightness);
        }
    }
    
    @Override
    public float getHue() {
        return LightSources.getAverageHue(lightSources);
    }
    
    @Override
    public void setHue(float hue) {
        for (LightSource light : lightSources) {
            light.setHue(hue);
        }
    }
    
    @Override
    public float getSaturation() {
        return LightSources.getAverageSaturation(lightSources);
    }
    
    @Override
    public void setSaturation(float saturation) {
        for (LightSource light : lightSources) {
            light.setSaturation(saturation);
        }
    }
    
    public void addLightSource(LightSource lightSource) {
        lightSources.add(lightSource);
    }
    
}
