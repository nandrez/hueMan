/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.lib

/**
 * This class runs UseCases and delegates the handling of Callbacks to the given UseCaseScheduler
 */
class UseCaseHandler private constructor(private val scheduler: UseCaseScheduler) {
    
    /**
     * Executes the UseCase with the given request-values.
     * The invocation of the Callback is delegated to the scheduler.
     */
    fun <Q : UseCase.Request, R : UseCase.Response> execute(useCase: UseCase<Q, R>, request: Q,
                                                            callback: UseCase.Callback<R>) {
        scheduler.execute {
            useCase.run(request, object : UseCase.Callback<R> {
                override fun onSuccess(response: R) = scheduler.notifyOnSuccess(response, callback)
                override fun onError() = scheduler.notifyOnError(callback)
            })
        }
    }

}
