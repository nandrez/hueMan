/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.net

import com.philips.lighting.hue.sdk.PHAccessPoint

data class AccessPoint(
        val ipAddress: String,
        val bridgeName: String,
        val macAddress: String,
        val userName: String
) {
    internal constructor(phAccessPoint: PHAccessPoint) : this(
            phAccessPoint.ipAddress,
            phAccessPoint.bridgeId,
            phAccessPoint.macAddress,
            phAccessPoint.username
    )
    
    internal fun mapToPHAccessPoint() = PHAccessPoint(ipAddress, userName, macAddress)
}