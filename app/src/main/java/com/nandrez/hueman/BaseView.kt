/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman

interface BaseView<T : BasePresenter> {
    
    var presenter: T
    
}
