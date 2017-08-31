/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.philips.lighting.hue.sdk.PHAccessPoint
import com.philips.lighting.hue.sdk.PHHueSDK
import com.philips.lighting.hue.sdk.notification.impl.PHNotificationManagerImpl
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
    
    @Test
    fun discoverBridge() {
        val deviceName = "testDevice"
        val callback = mock<HueService.DiscoverHueBridgeCallback>()
    
        testee.discoverBridge(deviceName, callback)
    
        Assert.assertTrue(deviceName == hueSdk.deviceName);
        Assert.assertTrue("HueMan" == hueSdk.appName);
        
        val phAccessPoints = listOf(PHAccessPoint("1.3.3.7", "testUser", "any"))
        fakeDiscovery(phAccessPoints)
        verify(callback, times(1)).onAccessPointsDiscovered(phAccessPoints.map { HueBridge(it) })
        
        fakeError()
        verify(callback, times(1)).onFailedDiscovery()
    }
    
    private fun fakeDiscovery(phAccessPoints: List<PHAccessPoint>) {
        (hueSdk.notificationManager as PHNotificationManagerImpl).notifyBridgeSearchResult(phAccessPoints)
    }
    
    private fun fakeError() {
        (hueSdk.notificationManager as PHNotificationManagerImpl).notifySDKError(42, "OHNOES")
    }
}