/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.data;

public interface Dimmable {
	
	static float MAX_BRIGHTNESS = 1f;
	static float MIN_BRIGHTNESS = 0f;
	
	boolean isOn();
	
	void on();
	
	void off();
	
	float getBrightness();
	
	void setBrightness(float brightness);
	
}
