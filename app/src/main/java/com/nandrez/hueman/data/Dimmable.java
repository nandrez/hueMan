/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.data;

public interface Dimmable {
	
	static int MAX_BRIGHTNESS = 100;
	static int MIN_BRIGHTNESS = 0;
	
	boolean isOn();
	
	void on();
	
	void off();
	
	int getBrightness();
	
	void setBrightness(int brightness);
	
}
