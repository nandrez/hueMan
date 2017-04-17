/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.ui;

/**
 * Use cases are the entry points to the domain layer.
 *
 * @param <Q> the request type
 * @param <P> the response type
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValue> {
    
    private Q requestValues;
    private UseCaseCallback<P> callback;
    
    public void setRequestValues(Q requestValues) {
        this.requestValues = requestValues;
    }
    
    public Q getRequestValues() {
        return requestValues;
    }
    
    public UseCaseCallback<P> getCallback() {
        return callback;
    }
    
    public void setCallback(UseCaseCallback<P> callback) {
        this.callback = callback;
    }
    
    void run() {
        executeUseCase(requestValues);
    }
    
    protected abstract void executeUseCase(Q requestValues);
    
    /**
     * Data passed to a request.
     */
    public interface RequestValues {
    }
    
    /**
     * Data received from a request.
     */
    public interface ResponseValue {
    }
    
    public interface UseCaseCallback<R> {
        void onSuccess(R response);
        void onError();
    }
    
}
