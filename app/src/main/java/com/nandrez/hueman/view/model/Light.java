/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.model;

import com.nandrez.hueman.data.LightSource;

public class Light extends LightSource {
    
    private boolean isOn;
    private float brightness;
    private float hue;
    private float saturation;
    
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
    public float getBrightness() {
        return brightness;
    }
    
    @Override
    public void setBrightness(float brightness) {
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
    public float getHue() {
        return hue;
    }
    
    @Override
    public void setHue(float hue) {
        if (hue < MIN_HUE) {
            this.hue = MIN_HUE;
            return;
        }
        if (hue > MAX_HUE) {
            this.hue = MAX_HUE;
            return;
        }
        this.hue = hue;
    }
    
    @Override
    public float getSaturation() {
        return saturation;
    }
    
    @Override
    public void setSaturation(float saturation) {
        if (saturation < MIN_SATURATION) {
            this.saturation = MIN_SATURATION;
            return;
        }
        if (saturation > MAX_SATURATION) {
            this.saturation = MAX_SATURATION;
            return;
        }
        this.saturation = saturation;
    }
    
}
