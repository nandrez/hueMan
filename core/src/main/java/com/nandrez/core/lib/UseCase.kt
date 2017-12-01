/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.lib

/**
 * This class represents a specific interaction with the application's network- and/or server-layers
 */
abstract class UseCase<in Q : UseCase.Request,  out R : UseCase.Response> {
    
    /**
     * Executes the UseCase with the given request-values.
     */
    internal fun run(request: Q, callback: Callback<R>) = executeUseCase(request, callback)
    
    protected abstract fun executeUseCase(request: Q, callback: Callback<R>)
    
    /**
     * Data passed to a request.
     */
    interface Request
    
    /**
     * Data received from a request.
     */
    interface Response
    
    /**
     * An interface allowing the caller to act upon success or failure of his/her request.
     */
    interface Callback<in R> {
        fun onSuccess(response: R)
        fun onError()
    }
}


