/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection.usecases

import com.nandrez.core.hue.connection.AccessPoint
import com.nandrez.core.hue.connection.HueConnector
import com.nandrez.core.hue.connection.HueService
import com.nandrez.core.lib.UseCase

class DiscoverHueBridge internal constructor(val hueConnector: HueService)
    : UseCase<DiscoverHueBridge.Request, DiscoverHueBridge.Response>() {
    
    public constructor() : this(HueConnector())
    
    override fun executeUseCase(request: Request, callback: Callback<Response>) {
        hueConnector.discoverBridge(request.deviceName, object : HueService.DiscoverHueBridgeCallback {
            
            override fun onAccessPointsDiscovered(accessPoints: List<AccessPoint>) {
                val response = Response(accessPoints)
                callback.onSuccess(response)
            }
    
            override fun onFailedDiscovery() {
                callback.onError()
            }
            
        })
    }
    
    data class Request(val deviceName: String) : UseCase.Request
    
    data class Response(val accessPoint: List<AccessPoint>) : UseCase.Response
    
}



