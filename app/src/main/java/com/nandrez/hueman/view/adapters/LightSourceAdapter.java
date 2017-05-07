/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.adapters;

import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.larswerkman.holocolorpicker.ValueBar;
import com.nandrez.hueman.R;
import com.nandrez.hueman.data.LightSource;
import com.nandrez.hueman.util.LightSources;

public class LightSourceAdapter extends RecyclerView.Adapter<LightSourceAdapter.LightSourceViewHolder> {
    
    private final List<LightSource> lightSources;
    
    public LightSourceAdapter() {
        lightSources = new ArrayList<>();
    }
    
    @Override
    public LightSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_light, parent, false);
        return new LightSourceViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(LightSourceViewHolder holder, int position) {
        LightSource lightSource = lightSources.get(position);
        holder.setLabel(lightSource.getName());
        holder.setColor(LightSources.getRgbColor(lightSource));
        holder.setSwitchState(lightSource.isOn());
        holder.setBrightness(lightSource.getBrightness());
    }
    
    public void replaceLightSources(List<LightSource> lightSources) {
        setList(lightSources);
        notifyDataSetChanged();
    }
    
    private void setList(List<LightSource> newLightSources) {
        lightSources.clear();
        lightSources.addAll(newLightSources);
    }
    
    @Override
    public int getItemCount() {
        return lightSources.size();
    }
    
    static class LightSourceViewHolder extends RecyclerView.ViewHolder {
        
        private final TextView lightLabel;
        private final ImageButton colorButton;
        private final ToggleButton lightSwitch;
        private final ValueBar brightnessBar;
    
        public LightSourceViewHolder(View itemView) {
            super(itemView);
            lightLabel = (TextView) itemView.findViewById(R.id.lightName);
            colorButton = (ImageButton) itemView.findViewById(R.id.lightColor);
            lightSwitch = (ToggleButton) itemView.findViewById(R.id.lightSwitch);
            brightnessBar = (ValueBar) itemView.findViewById(R.id.brightnessBar);
        }
    
        public void setLabel(String text) {
            lightLabel.setText(text);
        }
    
        public void setColor(int rgbColor) {
            colorButton.setBackgroundColor(rgbColor);
            brightnessBar.setColor(rgbColor);
        }
    
        public void setSwitchState(boolean isChecked) {
            lightSwitch.setChecked(isChecked);
        }
    
        public void setBrightness(float brightness) {
            brightnessBar.setValue(brightness);
        }
        
    }
    
}