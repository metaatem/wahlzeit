/**
 * MountainPhoto
 * 
 * 1.0
 * 
 * 07.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import org.wahlzeit.model.Photo;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class MountainPhoto extends Photo {
	
	
	private Mountain mount;
	
	/**
	 * Basic constructor
	 */
	public MountainPhoto() {
		super();
		this.mount = new Mountain("Mount Default", 4711);
	}

	/**
	 * @MethodType constructor
	 */
	public MountainPhoto(PhotoId myId) {
		super(myId);
		this.mount = new Mountain("Mount Default", 4711);
	}
	
	
	/**
	 * Constructor creating MountainPhoto initializing it's properties without PhotoID
	 * @param mName
	 * @param mHeight
	 */
	public MountainPhoto(Mountain mount) {
		super();
		this.mount = mount;
	}
	
	/**
	 * Constructor creating MountainPhoto initializing it's properties with PhotoID
	 * @param myId
	 * @param mName
	 * @param mHeight
	 */
	public MountainPhoto(PhotoId myId, Mountain mount) {
		super(myId);
		this.mount = mount;
	}
	
	/**
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public Mountain getMountain() {
		return this.mount;
	}
	
	/**
	 * @MethodType set
	 * @MethodProperty primitive
	 * @param mount
	 */
	public void setMountain(Mountain mount) {
		this.mount = mount;
	}
	
}