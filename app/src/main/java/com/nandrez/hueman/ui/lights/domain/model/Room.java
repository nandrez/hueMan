/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui.lights.domain.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nandrez.hueman.data.Dimmable;
import com.nandrez.hueman.data.Hueable;

public class Room implements Dimmable, Hueable {
    
    private List<Light> lights;
    
    public Room() {
        lights = new ArrayList<>();
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
            light.off();
        }
    }
    
    @Override
    public void off() {
        for (Light light : lights) {
            light.off();
        }
    }
    
    @Override
    public int getBrightness() {
        if (lights.isEmpty()) {
            return 0;
        }
        
        int average = 0;
        for (Light light : lights) {
            average += light.getBrightness();
        }
        return Math.round(average / lights.size());
    }
    
    @Override
    public void setBrightness(int brightness) {
        for (Light light : lights) {
            light.setBrightness(brightness);
        }
    }
    
    @Override
    public Object getHue() {
        throw new RuntimeException("not yet implemented!");
    }
    
    @Override
    public void setHue(Object hue) {
        for (Light light : lights) {
            light.setHue(hue);
        }
    }
    
}
