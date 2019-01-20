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
import org.wahlzeit.model.MountainManager;
import org.wahlzeit.utils.DesignPattern;
import org.wahlzeit.utils.MetaatemClassesUtil;
import com.googlecode.objectify.annotation.Subclass;


@Subclass
@DesignPattern(name = "Abstract Factory", participants = {"Concrete Product"})
@DesignPattern(name = "Factory Method", participants = {"Concrete Product"})
@DesignPattern(name = "Flyweight", participants = {"Concrete Flyweight"})
public class MountainPhoto extends Photo {
	
	
	private Mountain mount;
	
	/**
	 * Basic constructor
	 */
	public MountainPhoto() {
		super();
		
		this.mount = MountainManager.getInstance().createMountain(new MountainType("Mount Default", 4711));
	}

	/**
	 * @MethodType constructor
	 */
	public MountainPhoto(PhotoId myId) {
		super(myId);
		
		MetaatemClassesUtil.assertPhotoId(myId);
		
		this.mount = MountainManager.getInstance().createMountain(new MountainType("Mount Default", 4711));
	}
	
	
	/**
	 * Constructor creating MountainPhoto initializing it's properties without PhotoID
	 * @param mName
	 * @param mHeight
	 */
	public MountainPhoto(Mountain mount) {
		super();
		
		MetaatemClassesUtil.assertMountain(mount);
		
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
		
		MetaatemClassesUtil.assertPhotoId(myId);
		MetaatemClassesUtil.assertMountain(mount);
		
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
		MetaatemClassesUtil.assertNotNull(mount);
		
		this.mount = mount;
	}
	
}
