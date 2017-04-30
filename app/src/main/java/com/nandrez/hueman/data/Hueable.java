/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.data;

public interface Hueable {
    
    static float MAX_HUE = 360f;
    static float MIN_HUE = 0f;
    static float MAX_SATURATION = 1f;
    static float MIN_SATURATION = 0f;
    
    float getHue();
    
    void setHue(float hue);
    
    float getSaturation();
    
    void setSaturation(float saturation);
	
}
