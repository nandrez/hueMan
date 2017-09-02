/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection.usecases

import com.nandrez.core.hue.connection.HueBridge
import com.nandrez.core.hue.connection.HueConnector
import com.nandrez.core.hue.connection.HueService
import com.nandrez.core.lib.UseCase

class DiscoverHueBridge internal constructor(
    private val hueConnector: HueService

) : UseCase<DiscoverHueBridge.Request, DiscoverHueBridge.Response>() {
    
    constructor() : this(HueConnector())
    
    override fun executeUseCase(request: Request, callback: Callback<Response>) {
        hueConnector.discoverHueBridge(request.deviceName, object : HueService.DiscoverHueBridgeCallback {
            
            override fun onAccessPointsDiscovered(hueBridges: List<HueBridge>) {
                val response = Response(hueBridges)
                callback.onSuccess(response)
            }
    
            override fun onFailedDiscovery() {
                callback.onError()
            }
            
        })
    }
    
    data class Request(val deviceName: String) : UseCase.Request
    
    data class Response(val discoveredHueBridges: List<HueBridge>) : UseCase.Response
    
}



