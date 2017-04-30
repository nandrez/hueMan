/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.adapters;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.larswerkman.holocolorpicker.ValueBar;
import com.nandrez.hueman.R;
import com.nandrez.hueman.data.LightSource;
import com.nandrez.hueman.util.LightSources;

public class LightSourceAdapter extends ArrayAdapter<LightSource> {
    
    private final Context context;
    
    public LightSourceAdapter(Context context, List<LightSource> lights) {
        super(context, 0, lights);
        this.context = context;
    }
    
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.component_control_light, parent, false);
    
        TextView label = (TextView) view.findViewById(R.id.lightName);
        ImageButton colorButton = (ImageButton) view.findViewById(R.id.lightColor);
        ToggleButton lightSwitch = (ToggleButton) view.findViewById(R.id.lightSwitch);
        ValueBar brightnessBar = (ValueBar) view.findViewById(R.id.brightnessBar);
    
        LightSource lightSource = getItem(position);
        if (lightSource == null) {
            return view;
        }
        
        label.setText(lightSource.getName());
        int rgbColor = LightSources.getRgbColor(lightSource);
        colorButton.setBackgroundColor(rgbColor);
        lightSwitch.setChecked(lightSource.isOn());
        brightnessBar.setValue(lightSource.getBrightness());
        brightnessBar.setColor(rgbColor);
    
        return view;
    }
    
}