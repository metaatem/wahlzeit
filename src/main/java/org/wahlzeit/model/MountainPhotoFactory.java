/**
 * MountainPhotoFactory
 * 
 * 1.0
 * 
 * 07.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.exceptions.PhotoFactoryException;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.MetaatemClassesUtil;

public class MountainPhotoFactory extends PhotoFactory {
	
	private static final Logger log = Logger.getLogger(MountainPhotoFactory.class.getName());
	
	private static MountainPhotoFactory instance;
	
	/**
	 * 
	 */
	public MountainPhotoFactory() {
		super();
	}
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting MountainPhotoFactory").toString());
			MountainPhotoFactory.setInstance(new MountainPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(MountainPhotoFactory mPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to MountainPhotoFactory twice");
		}

		instance = mPhotoFactory;
	}
	
	/**
	 * @MethodType factory
	 */
	@Override
	public Photo createPhoto() {
		return new MountainPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 * @throws PhotoFactoryException 
	 * @MethodType factory
	 */
	@Override
	public Photo createPhoto(PhotoId id) throws PhotoFactoryException {
		MountainPhoto mPhoto;
		try {
			mPhoto = new MountainPhoto(id);
		}catch(IllegalArgumentException ie) {
			throw new PhotoFactoryException(ie.getMessage());
		}
		return mPhoto;
	}
	
	/**
	 * Creates new photo with Mountain object
	 * @throws PhotoFactoryException 
	 * @MethodType factory
	 */
	public Photo createPhoto(Mountain mountain) throws PhotoFactoryException {
		MountainPhoto mPhoto;
		try {
			mPhoto = new MountainPhoto(mountain);
		}catch(IllegalArgumentException ie) {
			throw new PhotoFactoryException(ie.getMessage());
		}
		return mPhoto;
	}

	/**
	 * Loads a photo. The Java object is loaded from the Google Datastore, the Images in all sizes are loaded from the
	 * Google Cloud storage.
	 */
	@Override
	public Photo loadPhoto(PhotoId id) {
	   /* Photo result =
                OfyService.ofy().load().type(Photo.class).ancestor(KeyFactory.createKey("Application", "Wahlzeit")).filter(Photo.ID, id).first().now();
        for (PhotoSize size : PhotoSize.values()) {
            GcsFilename gcsFilename = new GcsFilename("picturebucket", filename);



        }*/
		return null;
	}
}
