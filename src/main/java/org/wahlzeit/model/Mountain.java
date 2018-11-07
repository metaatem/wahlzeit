package org.wahlzeit.model;

public class Mountain {
	
	/**
	 * Instance variables
	 */
	private String mName;
	private int mHeight;
	
	/**
	 * Constructor 
	 * @param mName
	 * @param mHeight
	 */
	public Mountain(String mName, int mHeight) {
		this.mName = mName;
		this.mHeight = mHeight;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 * @return
	 */
	public String getMountainName() {
		return this.mName;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 * @return
	 */
	public int getMountainHeight() {
		return this.mHeight;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitve
	 * @param mName
	 */
	public void setMountainName(String mName) {
		this.mName = mName;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param mHeight
	 */
	public void setMountainHeight(int mHeight) {
		this.mHeight = mHeight;
	}
}
