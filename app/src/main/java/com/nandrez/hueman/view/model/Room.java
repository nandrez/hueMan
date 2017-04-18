/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.model;

import java.util.ArrayList;
import java.util.List;

import com.nandrez.hueman.data.Dimmable;
import com.nandrez.hueman.data.Hueable;
import com.nandrez.hueman.data.LightSource;

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
    public int getBrightness() {
        if (lightSources.isEmpty()) {
            return 0;
        }
        int average = 0;
        for (LightSource light : lightSources) {
            average += light.isOn() ? light.getBrightness() : 0;
        }
        return average / lightSources.size();
    }
    
    @Override
    public void setBrightness(int brightness) {
        for (LightSource light : lightSources) {
            light.setBrightness(brightness);
        }
    }
    
    @Override
    public Object getHue() {
        throw new NullPointerException("not yet implemented!");
    }
    
    @Override
    public void setHue(Object hue) {
        throw new RuntimeException("not yet implemented!");
    }
    
    public void addLightSource(LightSource lightSource) {
        lightSources.add(lightSource);
    }
    
}
