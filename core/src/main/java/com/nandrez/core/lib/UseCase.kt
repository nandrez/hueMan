/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.lib

/**
 *
 */
abstract class UseCase<Q : UseCase.RequestValues, R : UseCase.ResponseValue>() {
    
    /**
     * Executes the UseCase with the given request-values.
     */
    internal fun run(requestValues: Q, callback: Callback<R>) {
        executeUseCase(requestValues, callback)
    }
    
    protected abstract fun executeUseCase(requestValues: Q, callback: Callback<R>)
    
    /**
     * Data passed to a request.
     */
    interface RequestValues
    
    /**
     * Data received from a request.
     */
    interface ResponseValue
    
    /**
     *
     */
    interface Callback<in R> {
        fun onSuccess(response: R)
        fun onError()
    }
}


