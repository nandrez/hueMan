/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.net

internal interface HueService {
    
    fun discoverBridge(deviceName: String, callback: DiscoverHueBridgeCallback)
    
    interface DiscoverHueBridgeCallback {
        fun onAccessPointsDiscovered(accessPoints: List<AccessPoint>)
        fun onFailedDiscovery()
    }
    
}