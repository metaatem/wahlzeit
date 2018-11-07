package org.wahlzeit.model;

import java.util.logging.Logger;

public class MountainPhotoManager extends PhotoManager {
	
	
	protected static final MountainPhotoManager instance = new MountainPhotoManager();
	
	/**
	 * constructor
	 */
	public MountainPhotoManager() {
		photoTagCollector = MountainPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	/**
	 * @methodtype get
	 */
	public static MountainPhotoManager getInstance() {
		return instance;
	}
	
	
	/**
	 * @methodtype get
	 * @methodproperty regular
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
