/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.philips.lighting.hue.sdk.PHAccessPoint
import com.philips.lighting.hue.sdk.PHHueSDK
import com.philips.lighting.hue.sdk.bridge.impl.PHBridgeImpl
import com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl
import com.philips.lighting.model.PHBridge
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestHueConnector {
    
    private lateinit var testee: HueConnector
    private lateinit var hueSdk: PHHueSDK
    
    @Before
    fun setUp() {
        hueSdk = PHHueSDK.getInstance()
        testee = HueConnector()
    }
    
    @After
    fun tearDown() {
        hueSdk.destroySDK()
    }
    
    @Test
    fun discoverBridge() {
        val deviceName = "testDevice"
        val callback = mock<HueService.DiscoverHueBridgeCallback>()
    
        testee.discoverBridge(deviceName, callback)
    
        Assert.assertTrue(deviceName == hueSdk.deviceName)
        Assert.assertTrue("HueMan" == hueSdk.appName)
        
        val phAccessPoints = listOf(PHAccessPoint("1.3.3.7", "testUser", "any"))
        hueSdk.fakeDiscovery(phAccessPoints)
        verify(callback, times(1)).onAccessPointsDiscovered(phAccessPoints.map { HueBridge(it) })
        
        hueSdk.fakeError()
        verify(callback, times(1)).onFailedDiscovery()
    }
    
    @Test
    fun pairWithBridge_success() {
        val bridge = HueBridge("testBridge", "1.3.3.7", "any", "token")
        val phBridge = mock<PHBridgeImpl>()
        val pairingCallback = object : HueService.PairWithHueBridgeCallback {
            var isCalled = false
    
            override fun onConnectionEstablished(authToken: String) {
                Assert.assertTrue(bridge.authToken == authToken)
                Assert.assertTrue(phBridge == hueSdk.selectedBridge)
                isCalled = true
            }
            
            override fun onFailedConnection() = throw AssertionError("Unexpected call!")
        }
        
        testee.pairWithHueBridge(bridge, pairingCallback)
        hueSdk.fakeConnection(phBridge, bridge.authToken)
        
        Assert.assertTrue(pairingCallback.isCalled)
        
    }
    
    @Test
    fun pairWithBridge_error() {
        val bridge = HueBridge("testBridge", "1.3.3.7", "any", "token")
        val pairingCallback = object : HueService.PairWithHueBridgeCallback {
            var isCalled = false
    
            override fun onFailedConnection() {
                isCalled = true
            }
            
            override fun onConnectionEstablished(authToken: String) = throw AssertionError("Unexpected call!")
        }
        
        testee.pairWithHueBridge(bridge, pairingCallback)
        hueSdk.fakeError()
        
        Assert.assertTrue(pairingCallback.isCalled)
        
    }
    
    private fun PHHueSDK.fakeDiscovery(phAccessPoints: List<PHAccessPoint>) {
        (notificationManager as PHNotificationManagerImpl).notifyBridgeSearchResult(phAccessPoints)
    }
    
    private fun PHHueSDK.fakeError() {
        (notificationManager as PHNotificationManagerImpl).notifySDKError(42, "OHNOES")
    }
    
    private fun PHHueSDK.fakeConnection(phBridge: PHBridge, authToken: String) {
        (notificationManager as PHNotificationManagerImpl).notifyBridgeConnected(phBridge, authToken)
    }
}