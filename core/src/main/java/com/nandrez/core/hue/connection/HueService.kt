/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection

internal interface HueService {
    
    fun discoverBridge(deviceName: String, callback: DiscoverHueBridgeCallback)
    
    interface DiscoverHueBridgeCallback {
        fun onAccessPointsDiscovered(hueBridges: List<HueBridge>)
        fun onFailedDiscovery()
    }
    
    fun pairWithHueBridge(hueBridge: HueBridge, callback: PairWithHueBridgeCallback)
    
    interface PairWithHueBridgeCallback {
        fun onConnectionEstablished(token: String)
        fun onFailedConnection()
    }
    
}