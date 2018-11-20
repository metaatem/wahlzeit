/**
 * Mountain
 * 
 * 1.0
 * 
 * 07.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

public class Mountain {
	
	/**
	 * Instance variables
	 */
	private String mName;
	private int mHeight;
	
	/**
	 * Constructor 
	 * @param mName
	 * @param mHeight
	 */
	public Mountain(String mName, int mHeight) {
		this.mName = mName;
		this.mHeight = mHeight;
	}
	
	/**
	 * @MethodType get
	 * @MethodProperty primitive
	 * @return
	 */
	public String getMountainName() {
		return this.mName;
	}
	
	/**
	 * @MethodType get
	 * @MethodProperty primitive
	 * @return
	 */
	public int getMountainHeight() {
		return this.mHeight;
	}
	
	/**
	 * @MethodType set
	 * @MethodProperty primitve
	 * @param mName
	 */
	public void setMountainName(String mName) {
		this.mName = mName;
	}
	
	/**
	 * @MethodType set
	 * @MethodProperty primitive
	 * @param mHeight
	 */
	public void setMountainHeight(int mHeight) {
		this.mHeight = mHeight;
	}
}
