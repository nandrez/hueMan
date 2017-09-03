/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection

import com.nhaarman.mockito_kotlin.mock
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
    fun discoverHueBridge_success() {
        val deviceName = "testDevice"
        val phAccessPoint = PHAccessPoint("1.3.3.7", "testUser", "any")
        phAccessPoint.bridgeId = "testBridge"
        val callback = object: HueService.DiscoverHueBridgeCallback {
            var isCalled = false
            
            override fun onAccessPointsDiscovered(hueBridges: List<HueBridge>) {
                Assert.assertTrue(hueBridges.size == 1)
                val ap = hueBridges[0].phAccessPoint
                Assert.assertTrue(ap.bridgeId.toLowerCase() == phAccessPoint.bridgeId.toLowerCase())
                Assert.assertTrue(ap.ipAddress.toLowerCase() == phAccessPoint.ipAddress.toLowerCase())
                Assert.assertTrue(ap.macAddress.toLowerCase() == phAccessPoint.macAddress.toLowerCase())
                Assert.assertTrue(ap.username.toLowerCase() == phAccessPoint.username.toLowerCase())
                isCalled = true
            }
    
            override fun onFailedDiscovery() = throw AssertionError("Unexpected call!")
        }
    
        testee.discoverHueBridge(deviceName, callback)
    
        Assert.assertTrue(deviceName == hueSdk.deviceName)
        Assert.assertTrue("HueMan" == hueSdk.appName)
        hueSdk.fakeDiscovery(phAccessPoint)
        Assert.assertTrue(callback.isCalled)
        
    }
    
    @Test
    fun discoverHueBridge_failure() {
        val deviceName = "testDevice"
        val callback = object: HueService.DiscoverHueBridgeCallback {
            var isCalled = false
            
            override fun onFailedDiscovery() {
                isCalled = true
            }
            
            override fun onAccessPointsDiscovered(hueBridges: List<HueBridge>) {
                throw AssertionError("Unexpected call!")
            }
        }
        
        testee.discoverHueBridge(deviceName, callback)
        
        Assert.assertTrue(deviceName == hueSdk.deviceName)
        Assert.assertTrue("HueMan" == hueSdk.appName)
        hueSdk.fakeError()
        Assert.assertTrue(callback.isCalled)
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
        val bridge = HueBridge("testBridge".toUpperCase(), "1.3.3.7", "any", "token")
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
    
    private fun PHHueSDK.fakeDiscovery(phAccessPoint: PHAccessPoint) {
        (notificationManager as PHNotificationManagerImpl).notifyBridgeSearchResult(listOf(phAccessPoint))
    }
    
    private fun PHHueSDK.fakeError() {
        (notificationManager as PHNotificationManagerImpl).notifySDKError(42, "OHNOES")
    }
    
    private fun PHHueSDK.fakeConnection(phBridge: PHBridge, authToken: String) {
        (notificationManager as PHNotificationManagerImpl).notifyBridgeConnected(phBridge, authToken)
    }
}