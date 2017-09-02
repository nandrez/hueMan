/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection.usecases

import com.nandrez.core.hue.connection.HueBridge
import com.nandrez.core.hue.connection.HueConnector
import com.nandrez.core.hue.connection.HueService
import com.nandrez.core.lib.UseCase

class PairWithHueBridge internal constructor(
    private val hueConnector: HueService

) : UseCase<PairWithHueBridge.Request, PairWithHueBridge.Response>() {
    
    constructor() : this(HueConnector())
    
    override fun executeUseCase(request: Request, callback: Callback<Response>) {
        hueConnector.pairWithHueBridge(request.hueBridge, object : HueService.PairWithHueBridgeCallback {
            
            override fun onConnectionEstablished(authToken: String) {
                val response = Response(authToken)
                callback.onSuccess(response)
            }
    
            override fun onFailedConnection() {
                callback.onError()
            }
            
        })
    }
    
    data class Request(val hueBridge: HueBridge) : UseCase.Request
    
    data class Response(val token: String) : UseCase.Response
    
}