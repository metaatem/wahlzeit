package org.wahlzeit.model;

import org.wahlzeit.model.Photo;

public class MountainPhoto extends Photo {
	
	
	private Mountain mount;
	
	/**
	 * Basic constructor
	 */
	public MountainPhoto() {
		super();
	}

	/**
	 * @methodtype constructor
	 */
	public MountainPhoto(PhotoId myId) {
		super(myId);
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
	 * @methodtyp get
	 * @methodproperty primitive
	 */
	public Mountain getMountain() {
		return this.mount;
	}
	
	/**
	 * @methodtyp set
	 * @methodproperty primitive
	 * @param mount
	 */
	public void setMountain(Mountain mount) {
		this.mount = mount;
	}
	
}
