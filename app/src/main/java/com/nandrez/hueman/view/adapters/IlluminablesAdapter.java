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
import com.nandrez.hueman.data.Illuminable;
import com.nandrez.hueman.util.Illuminables;
import com.nandrez.hueman.view.model.Light;

public class IlluminablesAdapter extends RecyclerView.Adapter<IlluminablesAdapter.ViewHolder> {
    
    private final List<Illuminable> illuminables;
    
    public IlluminablesAdapter() {
        illuminables = new ArrayList<>();
    }
    
    public void replaceIlluminables(List<Illuminable> newIlluminables) {
        illuminables.clear();
        illuminables.addAll(newIlluminables);
        notifyDataSetChanged();
    }
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_light, parent, false);
        switch (viewType) {
            case R.layout.card_light:
                return new LightViewHolder(view);
            default:
                return new ViewHolder(view);
        }
    }
    
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Illuminable illuminable = illuminables.get(position);
        holder.bindView(illuminable);
    }
    
    @Override
    public int getItemViewType(int position) {
        Illuminable illuminable = illuminables.get(position);
        if (illuminable instanceof Light) {
            return R.layout.card_light;
        }
        return super.getItemViewType(position);
    }
    
    @Override
    public int getItemCount() {
        return illuminables.size();
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        
        private final TextView lightLabel;
        private final ImageButton colorButton;
        private final ToggleButton lightSwitch;
        private final ValueBar brightnessBar;
    
        public ViewHolder(View itemView) {
            super(itemView);
            lightLabel = (TextView) itemView.findViewById(R.id.lightName);
            colorButton = (ImageButton) itemView.findViewById(R.id.lightColor);
            lightSwitch = (ToggleButton) itemView.findViewById(R.id.lightSwitch);
            brightnessBar = (ValueBar) itemView.findViewById(R.id.brightnessBar);
        }
        
        public void bindView(Illuminable illuminable) {
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
    
    private static class LightViewHolder extends ViewHolder {
        public LightViewHolder(View itemView) {
            super(itemView);
        }
    
        @Override
        public void bindView(Illuminable illuminable) {
            super.bindView(illuminable);
            setLabel(illuminable.getName());
            setColor(Illuminables.getRgbColor(illuminable));
            setSwitchState(illuminable.isOn());
            setBrightness(illuminable.getBrightness());
        }
    }
    
}