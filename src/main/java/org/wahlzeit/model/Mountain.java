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
	public Mountain(MountainType mType, MountainId mId) {
		MetaatemClassesUtil.assertMountainType(mType);
		MetaatemClassesUtil.assertNotNull(mId);
		
		this.mountainType = mType;
		this.mountainId = mId;
	}
	
	public void setType(MountainType mountainType) {
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
