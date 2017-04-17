/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui.lights.domain.model;

import com.nandrez.hueman.data.Dimmable;
import com.nandrez.hueman.data.Hueable;

public class Light implements Dimmable, Hueable {
    
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
        return isOn ? brightness : 0;
    }
    
    @Override
    public void setBrightness(int brightness) {
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
