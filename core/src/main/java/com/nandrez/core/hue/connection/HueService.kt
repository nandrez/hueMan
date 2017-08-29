/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection

internal interface HueService {
    
    fun discoverBridge(deviceName: String, callback: DiscoverHueBridgeCallback)
    
    interface DiscoverHueBridgeCallback {
        fun onAccessPointsDiscovered(accessPoints: List<AccessPoint>)
        fun onFailedDiscovery()
    }
    
    fun pairWithHueBridge(accessPoint: AccessPoint, callback: PairWithHueBridgeCallback)
    
    interface PairWithHueBridgeCallback {
        fun onConnectionEstablished(token: String)
        fun onFailedConnection()
    }
    
}