/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.model;

import java.util.ArrayList;
import java.util.List;

import com.nandrez.hueman.data.LightSource;
import com.nandrez.hueman.util.LightSources;

public class Lamp extends LightSource {
    
    private List<Light> lights;
    
    public Lamp() {
        this.lights = new ArrayList<>();
    }
    
    @Override
    public boolean isOn() {
        for (LightSource light : lights) {
            if (light.isOn()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void on() {
        for (LightSource light : lights) {
            light.on();
        }
    }
    
    @Override
    public void off() {
        for (LightSource light : lights) {
            light.off();
        }
    }
    
    @Override
    public float getBrightness() {
        return LightSources.getAverageBrightness(lights);
    }
    
    @Override
    public void setBrightness(float brightness) {
        for (LightSource light : lights) {
            light.setBrightness(brightness);
        }
    }
    
    @Override
    public float getHue() {
        return LightSources.getAverageHue(lights);
    }
    
    @Override
    public void setHue(float hue) {
        for (LightSource light : lights) {
            light.setHue(hue);
        }
    }
    
    @Override
    public float getSaturation() {
        return LightSources.getAverageSaturation(lights);
    }
    
    @Override
    public void setSaturation(float saturation) {
        for (LightSource light : lights) {
            light.setSaturation(saturation);
        }
    }
    
    public void addLight(Light light) {
        lights.add(light);
    }
    
}
