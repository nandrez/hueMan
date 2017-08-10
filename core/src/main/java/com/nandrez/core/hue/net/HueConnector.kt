/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.net

import com.philips.lighting.hue.sdk.PHAccessPoint
import com.philips.lighting.hue.sdk.PHBridgeSearchManager
import com.philips.lighting.hue.sdk.PHHueSDK

internal class HueConnector(private val phHue: PHHueSDK = PHHueSDK.getInstance()) : HueService {
    val accessPoints = ArrayList<PHAccessPoint>()
    
    override fun discoverBridge(deviceName: String, callback: HueService.DiscoverHueBridgeCallback) {
        phHue.appName = "HueMan"
        phHue.deviceName = deviceName
        phHue.registerListener(object : BridgeDiscoveryListener() {
            
            override fun onAccessPointsFound(phAccessPoints: MutableList<PHAccessPoint>) {
                val accessPoints = phAccessPoints.map { AccessPoint(it) }
                callback.onAccessPointsDiscovered(accessPoints)
            }
    
            override fun onError(errorCode: Int, errorMessage: String) {
                callback.onFailedDiscovery()
            }
            
        })
        phHue.discoverBridge()
    }
    
    private fun PHHueSDK.registerListener(listener: HueServiceAdapter) {
        notificationManager.registerSDKListener(listener)
    }
    
    private fun PHHueSDK.discoverBridge() {
        val bridgeSearchManager = getSDKService(PHHueSDK.SEARCH_BRIDGE) as PHBridgeSearchManager
        bridgeSearchManager.search(true, true)
    }
    
}