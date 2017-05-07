/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.model;

import java.util.ArrayList;
import java.util.List;

import com.nandrez.hueman.data.LightSource;
import com.nandrez.hueman.util.Illuminables;

public class Lamp extends LightSource {
    
    private final List<Light> lights;
    
    public Lamp() {
        lights = new ArrayList<>();
    }
    
    public void addLight(Light light) {
        lights.add(light);
    }
    
    @Override
    public boolean isOn() {
        for (Light light : lights) {
            if (light.isOn()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void on() {
        for (Light light : lights) {
            light.on();
        }
    }
    
    @Override
    public void off() {
        for (Light light : lights) {
            light.off();
        }
    }
    
    @Override
    public float getBrightness() {
        return Illuminables.getAverageBrightness(lights);
    }
    
    @Override
    public void setBrightness(float brightness) {
        for (Light light : lights) {
            light.setBrightness(brightness);
        }
    }
    
    @Override
    public float getHue() {
        return Illuminables.getAverageHue(lights);
    }
    
    @Override
    public void setHue(float hue) {
        for (Light light : lights) {
            light.setHue(hue);
        }
    }
    
    @Override
    public float getSaturation() {
        return Illuminables.getAverageSaturation(lights);
    }
    
    @Override
    public void setSaturation(float saturation) {
        for (Light light : lights) {
            light.setSaturation(saturation);
        }
    }
    
}
