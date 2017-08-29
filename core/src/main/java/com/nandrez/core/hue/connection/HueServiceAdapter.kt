/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection

import com.philips.lighting.hue.sdk.PHAccessPoint
import com.philips.lighting.hue.sdk.PHSDKListener
import com.philips.lighting.model.PHBridge
import com.philips.lighting.model.PHHueParsingError

internal sealed class HueServiceAdapter : PHSDKListener {
    override fun onAccessPointsFound(phAccessPoints: MutableList<PHAccessPoint>) { }
    override fun onError(errorCode: Int, errorMessage: String) { }
    override fun onAuthenticationRequired(result: PHAccessPoint) { }
    override fun onConnectionResumed(result: PHBridge) { }
    override fun onBridgeConnected(result: PHBridge, user: String) { }
    override fun onParsingErrors(result: MutableList<PHHueParsingError>) { }
    override fun onConnectionLost(result: PHAccessPoint) { }
    override fun onCacheUpdated(result: MutableList<Int>, bridge: PHBridge) { }
}

internal abstract class BridgeDiscoveryListener : HueServiceAdapter() {
    override abstract fun onAccessPointsFound(phAccessPoints: MutableList<PHAccessPoint>)
    override abstract fun onError(errorCode: Int, errorMessage: String)
}