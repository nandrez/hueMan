/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class HueActivities {
    
    public static void addFragment(FragmentManager fragmentManager, Fragment fragment, int resourceId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(resourceId, fragment);
        transaction.commit();
    }
    
}