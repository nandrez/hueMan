/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.view.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.nandrez.hueman.R;
import com.nandrez.hueman.view.model.Light;

public class LightComponentAdapter extends ArrayAdapter<Light> {
    
    private final Context context;
    
    public LightComponentAdapter(Context context, @LayoutRes int resource, List<Light> lights) {
        super(context, resource, lights);
        this.context = context;
    }
    
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.component_control_light, parent, false);
        
        return view;
    }
}