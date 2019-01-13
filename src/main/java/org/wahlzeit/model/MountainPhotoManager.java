/**
 * MountainPhotoManager
 * 
 * 1.0
 * 
 * 07.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.utils.DesignPattern;
import org.wahlzeit.utils.MetaatemClassesUtil;
import org.wahlzeit.utils.DesignPattern;

@DesignPattern(name = "Singleton (classic initialization)", participants = {""})
@DesignPattern(name = "Flyweight", participants = {"Flyweight Factory"})
public class MountainPhotoManager extends PhotoManager {
	
	
	protected static final MountainPhotoManager instance = new MountainPhotoManager();
	
	private static final Logger log = Logger.getLogger(MountainPhotoManager.class.getName());
	
	/**
	 * constructor
	 */
	public MountainPhotoManager() {
		photoTagCollector = MountainPhotoFactory.getInstance().createPhotoTagCollector();
	}

	
	/**
	 * @MethodType get
	 */
	public static MountainPhotoManager getInstance() {
		return instance;
	}
	
	
	/**
	 * @MethodType get
	 * @MethodProperty regular
	 */
	public Photo getPhotoFromId(PhotoId id) {
		MetaatemClassesUtil.assertPhotoId(id);
		
		if (id == null) {
			return null;
		}

		Photo result = doGetPhotoFromId(id);

		if (result == null) {
			result = MountainPhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	}
}
