/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection

import com.philips.lighting.hue.sdk.PHAccessPoint
import com.philips.lighting.hue.sdk.PHBridgeSearchManager
import com.philips.lighting.hue.sdk.PHHueSDK
import com.philips.lighting.model.PHBridge

internal class HueConnector(private val phHue: PHHueSDK = PHHueSDK.getInstance()) : HueService {
    
    override fun discoverHueBridge(deviceName: String, callback: HueService.DiscoverHueBridgeCallback) {
        phHue.appName = "HueMan"
        phHue.deviceName = deviceName
        phHue.registerListener(object : BridgeDiscoveryListener() {
            
            override fun onAccessPointsFound(phAccessPoints: MutableList<PHAccessPoint>) {
                val accessPoints = phAccessPoints.map { HueBridge(it) }
                callback.onAccessPointsDiscovered(accessPoints)
            }
    
            override fun onError(errorCode: Int, errorMessage: String) {
                callback.onFailedDiscovery()
            }
            
        })
        phHue.discoverBridge()
    }
    
    override fun pairWithHueBridge(hueBridge: HueBridge, callback: HueService.PairWithHueBridgeCallback) {
        phHue.registerListener(object : BridgePairingListener() {
            
            override fun onAuthenticationRequired(accessPoint: PHAccessPoint) {
                phHue.startPushlinkAuthentication(accessPoint)
            }
    
            override fun onBridgeConnected(bridge: PHBridge, authToken: String) {
                phHue.selectedBridge = bridge
                phHue.enableHeartbeat(bridge, PHHueSDK.HB_INTERVAL.toLong())
                callback.onConnectionEstablished(authToken)
            }
    
            override fun onError(errorCode: Int, errorMessage: String) {
                callback.onFailedConnection()
            }
            
        })
        phHue.connect(hueBridge.phAccessPoint)
    }
    
    private fun PHHueSDK.registerListener(listener: HueServiceAdapter) {
        notificationManager.registerSDKListener(listener)
    }
    
    private fun PHHueSDK.discoverBridge() {
        val bridgeSearchManager = getSDKService(PHHueSDK.SEARCH_BRIDGE) as PHBridgeSearchManager
        bridgeSearchManager.search(true, true)
    }
    
}