/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class HueActivities {
    
    public static void addFragment(FragmentManager fragmentManager, Fragment fragment, int resourceId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(resourceId, fragment);
        transaction.commit();
    }
    
}