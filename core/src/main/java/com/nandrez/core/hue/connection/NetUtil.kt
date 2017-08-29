/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection

import com.philips.lighting.hue.sdk.PHAccessPoint

data class HueBridge(
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
}

internal fun PHAccessPoint.create(hueBridge: HueBridge) {
    PHAccessPoint(hueBridge.ipAddress, hueBridge.userName, hueBridge.macAddress)
}