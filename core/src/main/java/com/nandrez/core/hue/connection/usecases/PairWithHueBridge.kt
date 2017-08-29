/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection.usecases

import com.nandrez.core.hue.connection.AccessPoint
import com.nandrez.core.hue.connection.HueConnector
import com.nandrez.core.hue.connection.HueService
import com.nandrez.core.lib.UseCase

class PairWithHueBridge internal constructor(val hueConnector: HueService)
    : UseCase<PairWithHueBridge.Request, PairWithHueBridge.Response>() {
    
    public constructor() : this(HueConnector())
    
    override fun executeUseCase(request: Request, callback: Callback<Response>) {
        
        hueConnector.pairWithHueBridge(request.accessPoint, object : HueService.PairWithHueBridgeCallback {
            
            override fun onConnectionEstablished(token: String) {
                val response = Response(token)
                callback.onSuccess(response)
            }
    
            override fun onFailedConnection() {
                callback.onError()
            }
            
        })
    }
    
    data class Request(val accessPoint: AccessPoint) : UseCase.Request
    
    data class Response(val token: String) : UseCase.Response
    
}