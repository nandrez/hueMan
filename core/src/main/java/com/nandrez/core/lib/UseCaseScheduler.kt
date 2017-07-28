/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.lib

import java.util.concurrent.Executor

/**
 * Schedules the execution of UseCases and notifies when they are completed by invoking the Callback.
 */
interface UseCaseScheduler : Executor {
    
    /**
     * Invokes the Callback's onSuccess method.
     */
    fun <R : UseCase.ResponseValue> notifyResponse(response: R, useCaseCallback: UseCase.Callback<R>)
    
    /**
     * Invokes the Callback's onError method.
     */
    fun <R : UseCase.ResponseValue> notifyError(useCaseCallback: UseCase.Callback<R>)
    
}