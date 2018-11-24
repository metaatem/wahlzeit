/**
 * CoordinateTests
 * 
 * 1.0
 * 
 * 15.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;


public class CartesianCoordinate extends AbstractCoordinate {
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * Constructor for Coordinate class
	 * 
	 * @param x		x-coordinate
	 * @param y		y-coordinate
	 * @param z		z-coordinate
	 */
	protected CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Helper handing back properties as String
	 * @MethodType get
	 * @MethodProperty primitive
	 * @return 
	 */
	public String propertiesAsString() {
		return Double.toString(x) + "\n" + Double.toString(y) + "\n" + Double.toString(z);
	}
	
	/**
	 * Setter for Coordinate class to set x,y,z in one go.
	 * @methodtyp set
	 * @methodproperty primitive
	 * @param x		x-coordinate
	 * @param y		y-coordinate
	 * @param z		z-coordinate
	 */
	protected void setXYZ(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Setter for x-coordinate
	 * @methodtype set
	 * @methodproperty primitive
	 * @param x		x-coordinate
	 */
	protected void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Setter for y-coordinate
	 * @methodtype set
	 * @methodproperty primitive
	 * @param y		y-coordinate
	 */
	protected void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Setter for z-coordinate
	 * @methodtype set
	 * @methodproperty primitive
	 * @param z		z-coordinate
	 */
	protected void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * Getter to get x,y,z coordinates in one go
	 * @methodtype get
	 * @methodproperty primitive
	 * @return		Array containing x,y,z
	 */
	protected double[] getXYZ(){
		double[] vector = new double[] {x,y,z};
		return vector;
	}
	
	/**
	 * Getter for x-coordinate
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	x-coordinate
	 */
	protected double getX() {
		return this.x;
	}
	
	/**
	 * Getter for x-coordinate
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	y-coordinate
	 */
	protected double getY() {
		return this.y;
	}
	
	/**
	 * Getter for x-coordinate
	 * @MethodType get 
	 * @MethodProperty primitive
	 * @return	z-coordinate
	 */
	protected double getZ() {
		return this.z;
	}
	
	/**
	 * @MethodProperty primitive
	 */
	protected CartesianCoordinate basicAsCartesianCoordinate() {
		return this;
	}
	
	/**
	 * @MethodProperty primitive
	 */
	protected CylindricalCoordinate basicAsCylindricalCoordinate() {
		return new CylindricalCoordinate( Math.sqrt(Math.pow(x, 2) + Math.pow(this.y, 2)),
				Math.atan2(this.y, this.x), this.z);	
	}

	/**
	 * @MethodProperty primitive
	 */
	protected SphericCoordinate basicAsSphericCoordinate() {
		return new SphericCoordinate( Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2)),
				Math.acos( this.z / Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2))),
				Math.atan2(this.y, this.x)  );
	}

	/**
	 * @MethodProperty primitive
	 */
	protected boolean basicIsEqual(Coordinate c) {
		return ( Double.compare(new Double(this.x), new Double(c.asCartesianCoordinate().getX())) == 0 
			&&   Double.compare(new Double(this.y), new Double(c.asCartesianCoordinate().getY())) == 0
			&&   Double.compare(new Double(this.z), new Double(c.asCartesianCoordinate().getZ())) == 0 );
	}
	
}
