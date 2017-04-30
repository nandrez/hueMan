/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.adapters;

import java.util.ArrayList;
import java.util.List;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.larswerkman.holocolorpicker.ValueBar;
import com.nandrez.hueman.R;
import com.nandrez.hueman.data.LightSource;
import com.nandrez.hueman.util.LightSources;

public class LightSourceAdapter extends BaseAdapter {
    
    private final List<LightSource> lightSources;
    
    public LightSourceAdapter() {
        lightSources = new ArrayList<>();
    }
    
    public void replaceData(List<LightSource> lightSources) {
        setList(lightSources);
        notifyDataSetChanged();
    }
    
    private void setList(List<LightSource> newLightSources) {
        lightSources.clear();
        lightSources.addAll(newLightSources);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.component_control_light, parent, false);
        }
    
        LightSource lightSource = getItem(position);
        if (lightSource == null) {
            return view;
        }
        
        TextView label = (TextView) view.findViewById(R.id.lightName);
        ImageButton colorButton = (ImageButton) view.findViewById(R.id.lightColor);
        ToggleButton lightSwitch = (ToggleButton) view.findViewById(R.id.lightSwitch);
        ValueBar brightnessBar = (ValueBar) view.findViewById(R.id.brightnessBar);
        
        label.setText(lightSource.getName());
        int rgbColor = LightSources.getRgbColor(lightSource);
        colorButton.setBackgroundColor(rgbColor);
        lightSwitch.setChecked(lightSource.isOn());
        brightnessBar.setValue(lightSource.getBrightness());
        brightnessBar.setColor(rgbColor);
        
        return view;
    }
    
    @Override
    public int getCount() {
        return lightSources.size();
    }
    
    @Override
    public LightSource getItem(int position) {
        return lightSources.get(position);
    }
    
    @Override
    public long getItemId(int position) {
        return position;
    }
    
}