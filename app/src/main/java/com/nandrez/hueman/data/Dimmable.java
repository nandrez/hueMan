/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.data;

public interface Dimmable {
	
	boolean isOn();
	
	void on();
	
	void off();
	
	int getBrightness();
	
	void setBrightness(int brightness);
	
}
