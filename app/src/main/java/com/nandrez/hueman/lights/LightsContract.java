/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.lights;

import java.util.List;

import com.nandrez.hueman.BasePresenter;
import com.nandrez.hueman.BaseView;
import com.nandrez.hueman.data.Dimmable;
import com.nandrez.hueman.data.Hueable;
import com.nandrez.hueman.data.Illuminable;

public interface LightsContract {
    
    interface View extends BaseView<Presenter> {
        
        void displayLoadingIndicator(boolean shown);
        
        void showIlluminables(List<Illuminable> illuminables);
        
    }
    
    interface Presenter extends BasePresenter {
    
        void result(int requestCode, int resultCode);
        
        void loadIlluminables(boolean forceReload);
        
        void addNewIlluminable();
        
        void turnOnIlluminables(Dimmable... dimmables);
    
        void turnOffIlluminables(Dimmable... dimmables);
        
        void dimIlluminables(float brightness, Dimmable... dimmables);
    
        void hueIlluminables(float hue, Hueable... huables);
    
        void saturateIlluminables(float saturation, Hueable... huables);
        
    }
    
}
