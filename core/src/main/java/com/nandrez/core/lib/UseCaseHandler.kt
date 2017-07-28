/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.lib

/**
 * This class runs UseCases and delegates the handling of Callbacks to the given UseCaseScheduler
 */
class UseCaseHandler private constructor(private val scheduler: UseCaseScheduler) {
    
    /**
     * Executes the UseCase with the given Values.
     * The invocation of the Callback is delegated to the scheduler.
     */
    fun <Q : UseCase.RequestValues, R : UseCase.ResponseValue> execute(useCase: UseCase<Q, R>,
                                                                       requestValues: Q,
                                                                       callback: UseCase.Callback<R>) {
        scheduler.execute {
            
            useCase.run(requestValues, object : UseCase.Callback<R> {
                override fun onSuccess(response: R) {
                    scheduler.notifyResponse(response, callback)
                }
                override fun onError() {
                    scheduler.notifyError(callback)
                }
            })
            
        }
    }

}
