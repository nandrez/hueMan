/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.util;

import java.util.List;
import android.graphics.Color;

import com.nandrez.hueman.data.LightSource;

public class LightSources {
    
    public static float getAverageHue(List<? extends LightSource> lightSources) {
        int activeLights = 0;
        float sum = 0f;
        for (LightSource light : lightSources) {
            if (light.isOn()) {
                sum += light.getHue();
                activeLights++;
            }
        }
        return activeLights > 0 ? sum / activeLights : 0;
    }
    
    public static float getAverageSaturation(List<? extends LightSource> lightSources) {
        int activeLights = 0;
        float sum = 0f;
        for (LightSource light : lightSources) {
            if (light.isOn()) {
                sum += light.getSaturation();
                activeLights++;
            }
        }
        return activeLights > 0 ? sum / activeLights : 0;
    }
    
    public static float getAverageBrightness(List<? extends LightSource> lightSources) {
        int activeLights = 0;
        float sum = 0f;
        for (LightSource light : lightSources) {
            if (light.isOn()) {
                sum += light.getBrightness();
                activeLights++;
            }
        }
        return activeLights > 0 ? sum / activeLights : 0;
    }
    
    public static int getRgbColor(LightSource lightSource) {
        float h = lightSource.getHue();
        float s = lightSource.getSaturation();
        float b = lightSource.getBrightness();
        return Color.HSVToColor(new float[] {h, s, b});
    }
    
}
