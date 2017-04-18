/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman;

public interface BaseView<T extends BasePresenter> {
    
    void setPresenter(T presenter);
    
}
