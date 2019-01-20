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
	
	private MountainType mountainType;
	private MountainId mountainId;
	
	/**
	 * Constructor 
	 * @param mName
	 * @param mHeight
	 */
	
	public Mountain(MountainType mountainType, MountainId mountainId) {
		MetaatemClassesUtil.assertNotNull(mountainType);
		MetaatemClassesUtil.assertNotNull(mountainId);
		
		this.mountainType = mountainType;
		this.mountainId = mountainId;
	}
	
	public Mountain(MountainType mountainType) {
		MetaatemClassesUtil.assertNotNull(mountainType);
		
		this.mountainType = mountainType;
		this.mountainId = MountainId.getNextId();
	}
	
	public void setType(MountainType mountainType) {
		MetaatemClassesUtil.assertNotNull(mountainType);
		
		this.mountainType = mountainType;
	}
	
	public void setId(MountainId mountainId) {
		this.mountainId = mountainId;
	}
	
	public MountainType getType() {
		return this.mountainType;
	}
	
	public MountainId getId() {
		return this.mountainId;
	}
	
	
	
}
