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
