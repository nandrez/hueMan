/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.data;

public interface Illuminable extends Dimmable, Hueable {
    
    String getName();
    
    void setName(String name);
    
}
