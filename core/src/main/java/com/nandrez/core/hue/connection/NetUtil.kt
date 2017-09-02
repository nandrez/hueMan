/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection

import com.philips.lighting.hue.sdk.PHAccessPoint

/**
 * This class represents an access-point the user can connect to.
 */
data class HueBridge(
    val bridgeName: String,
    val ipAddress: String,
    val macAddress: String,
    val authToken: String
) {
    
    internal val phAccessPoint: PHAccessPoint
        get() = PHAccessPoint(ipAddress, authToken, macAddress)
    
    internal constructor(phAccessPoint: PHAccessPoint) : this(
            phAccessPoint.ipAddress,
            phAccessPoint.bridgeId,
            phAccessPoint.macAddress,
            phAccessPoint.username
    )
    
}