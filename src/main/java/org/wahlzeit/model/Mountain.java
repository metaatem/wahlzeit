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

import org.wahlzeit.utils.MetaatemClassesUtil;

public class Mountain {
	
	/**
	 * Instance variables
	 */
	private String mName;
	private double mHeight;
	
	/**
	 * Constructor 
	 * @param mName
	 * @param mHeight
	 */
	public Mountain(String mName, double mHeight) {
		MetaatemClassesUtil.assertName(mName);
		MetaatemClassesUtil.assertHeight(mHeight);
		
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
	public double getMountainHeight() {
		return this.mHeight;
	}
	
	/**
	 * @MethodType set
	 * @MethodProperty primitve
	 * @param mName
	 */
	public void setMountainName(String mName) {
		MetaatemClassesUtil.assertName(mName);
		
		this.mName = mName;
	}
	
	/**
	 * @MethodType set
	 * @MethodProperty primitive
	 * @param mHeight
	 */
	public void setMountainHeight(int mHeight) {
		MetaatemClassesUtil.assertHeight(mHeight);
		
		this.mHeight = mHeight;
	}
	
}
