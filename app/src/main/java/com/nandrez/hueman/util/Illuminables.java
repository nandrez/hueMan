/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.util;

import java.util.List;
import android.graphics.Color;

import com.nandrez.hueman.data.Illuminable;

public class Illuminables {
    
    public static float getAverageHue(List<? extends Illuminable> illuminables) {
        int activeLights = 0;
        float sum = 0f;
        for (Illuminable illuminable : illuminables) {
            if (illuminable.isOn()) {
                sum += illuminable.getHue();
                activeLights++;
            }
        }
        return activeLights > 0 ? sum / activeLights : 0;
    }
    
    public static float getAverageSaturation(List<? extends Illuminable> illuminables) {
        int activeLights = 0;
        float sum = 0f;
        for (Illuminable illuminable : illuminables) {
            if (illuminable.isOn()) {
                sum += illuminable.getSaturation();
                activeLights++;
            }
        }
        return activeLights > 0 ? sum / activeLights : 0;
    }
    
    public static float getAverageBrightness(List<? extends Illuminable> illuminables) {
        int activeLights = 0;
        float sum = 0f;
        for (Illuminable illuminable : illuminables) {
            if (illuminable.isOn()) {
                sum += illuminable.getBrightness();
                activeLights++;
            }
        }
        return activeLights > 0 ? sum / activeLights : 0;
    }
    
    public static int getRgbColor(Illuminable illuminable) {
        return Color.HSVToColor(new float[] {
                illuminable.getHue(),
                illuminable.getSaturation(),
                illuminable.getBrightness()
        });
    }
    
}
