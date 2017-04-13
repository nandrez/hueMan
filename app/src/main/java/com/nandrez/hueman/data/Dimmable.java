/*
 * Light.java 
 *
 * Creator:
 * 30.03.17 00:38 nacho
 *
 * Maintainer:
 * 30.03.17 00:38 nacho
 *
 * Last Modification:
 * $Id: File Header.java 27100 2015-12-10 13:04:02Z nandrez $
 *
 * Copyright (c) 2017 nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.data;

public interface Dimmable {
	
	boolean isOn();
	
	void on();
	
	void off();
	
	int getBrightness();
	
	void setBrightness(int brightness);
	
}
