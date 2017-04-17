/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui.lights.domain.model;

import com.nandrez.hueman.data.LightSource;

public class Light implements LightSource {
    
    private boolean isOn;
    private int brightness;
    
    @Override
    public boolean isOn() {
        return isOn;
    }
    
    @Override
    public void on() {
        isOn = true;
    }
    
    @Override
    public void off() {
        isOn = false;
    }
    
    @Override
    public int getBrightness() {
        return brightness;
    }
    
    @Override
    public void setBrightness(int brightness) {
        if (brightness < MIN_BRIGHTNESS) {
            this.brightness = MIN_BRIGHTNESS;
            return;
        }
        if (brightness > MAX_BRIGHTNESS) {
            this.brightness = MAX_BRIGHTNESS;
            return;
        }
        this.brightness = brightness;
    }
    
    @Override
    public Object getHue() {
        throw new RuntimeException("not yet implemented!");
    }
    
    @Override
    public void setHue(Object hue) {
        throw new RuntimeException("not yet implemented!");
    }
    
}
