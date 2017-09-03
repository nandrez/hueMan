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
    
    internal constructor(phAccessPoint: PHAccessPoint): this(
            phAccessPoint.bridgeId ?: "",
            phAccessPoint.ipAddress ?: "",
            phAccessPoint.macAddress ?: "",
            phAccessPoint.username ?: ""
    )
    
    internal val phAccessPoint: PHAccessPoint get() {
        val ap = PHAccessPoint()
        ap.bridgeId = bridgeName
        ap.ipAddress = ipAddress
        ap.macAddress = macAddress
        ap.username = authToken
        return ap
    }
    
}