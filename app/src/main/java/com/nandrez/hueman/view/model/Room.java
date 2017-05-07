/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.model;

import java.util.ArrayList;
import java.util.List;

import com.nandrez.hueman.data.Illuminable;
import com.nandrez.hueman.data.LightSource;
import com.nandrez.hueman.util.Illuminables;

public class Room implements Illuminable {
    
    private final List<LightSource> lightSources;
    private String name;
    
    public Room() {
        lightSources = new ArrayList<>();
    }
    
    public void addLightSource(LightSource lightSource) {
        lightSources.add(lightSource);
    }
    
    @Override
    public boolean isOn() {
        for (LightSource lightSource : lightSources) {
            if (lightSource.isOn()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void on() {
        for (LightSource lightSource : lightSources) {
            lightSource.on();
        }
    }
    
    @Override
    public void off() {
        for (LightSource lightSource : lightSources) {
            lightSource.off();
        }
    }
    
    @Override
    public float getBrightness() {
        return Illuminables.getAverageBrightness(lightSources);
    }
    
    @Override
    public void setBrightness(float brightness) {
        for (LightSource light : lightSources) {
            light.setBrightness(brightness);
        }
    }
    
    @Override
    public float getHue() {
        return Illuminables.getAverageHue(lightSources);
    }
    
    @Override
    public void setHue(float hue) {
        for (LightSource light : lightSources) {
            light.setHue(hue);
        }
    }
    
    @Override
    public float getSaturation() {
        return Illuminables.getAverageSaturation(lightSources);
    }
    
    @Override
    public void setSaturation(float saturation) {
        for (LightSource light : lightSources) {
            light.setSaturation(saturation);
        }
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
}
