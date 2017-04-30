/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import java.util.List;

import com.nandrez.hueman.BasePresenter;
import com.nandrez.hueman.BaseView;
import com.nandrez.hueman.data.LightSource;

public interface LightsContract {
    
    interface View extends BaseView<Presenter> {
        
        void showLightsources(List<LightSource> lightsources);
        
    }
    
    interface Presenter extends BasePresenter {
        
        void loadLightSources(boolean forceReload);
        
        void addNewLightSource();
        
        void turnOnLightSources(LightSource... lightsource);
    
        void turnOffLightSources(LightSource... lightsource);
        
        void dimLightSources(float brightness, LightSource... lightSource);
    
        void hueLightSources(float hue, LightSource... lightSource);
    
        void saturateLightSources(float saturation, LightSource... lightSource);
        
    }
    
}
