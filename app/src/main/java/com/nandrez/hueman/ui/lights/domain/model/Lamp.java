/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui.lights.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.nandrez.hueman.data.LightSource;

public class Lamp implements LightSource {
    
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
    public int getBrightness() {
        if (lights.isEmpty()) {
            return 0;
        }
        int average = 0;
        for (LightSource light : lights) {
            average += light.isOn() ? light.getBrightness() : 0;
        }
        return Math.round(average / lights.size());
    }
    
    @Override
    public void setBrightness(int brightness) {
        for (LightSource light : lights) {
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
    
    public void addLight(Light light) {
        lights.add(light);
    }
    
}
