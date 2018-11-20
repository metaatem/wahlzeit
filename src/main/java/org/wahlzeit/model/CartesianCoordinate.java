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


public class CartesianCoordinate implements Coordinate {
	
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
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	/**
	 * Calculates distance from this coordinate to the coordinate c
	 * @MethodType get
	 * @MethodProperty primitive
	 * @param c		Coordinate the distance is calculated to 
	 * @return 		Calculated distance
	 */
	public double getCartesianDistance(Coordinate c) {
		return Math.sqrt( Math.pow(c.asCartesianCoordinate().getX() - this.x, 2) 
						+ Math.pow(c.asCartesianCoordinate().getY() - this.y, 2) 
						+ Math.pow(c.asCartesianCoordinate().getZ() - this.z, 2) );
	}
	
	/**
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CylindricalCoordinate asCylindricalCoordinate() {
		return new CylindricalCoordinate( Math.sqrt(Math.pow(x, 2) + Math.pow(this.y, 2)),
						Math.atan2(this.y, this.x), this.z);	
	}
	
	/**
	 * Converts cartesian coordinate into spheric coordinate
	 * See 'Cartesian Coordinates' at https://en.wikipedia.org/wiki/Spherical_coordinate_system
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public SphericCoordinate asSphericCoordinate() {
		return new SphericCoordinate( Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2)),
								Math.acos( this.z / Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2))),
								Math.atan2(this.y, this.x)  );
	}

	/**
	 * Calculates central angle based on longitude and latitude
	 * See https://en.wikipedia.org/wiki/Great-circle_distance
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCentralAngle(Coordinate c) {
		double lat1 = this.asSphericCoordinate().getTheta();
		double long1 = this.asSphericCoordinate().getPhi();
		double lat2 = c.asSphericCoordinate().getTheta();
		double long2 = c.asSphericCoordinate().getPhi();
		
		return Math.acos(Math.sin(lat1) * Math.sin(lat2)
				+ Math.cos(lat1) * Math.cos(lat2) * Math.cos(Math.abs(long1 - long2)));
	}

	/**
	 * Comparing this coordinate with another coordinate c 
	 * @MethodType comparison
	 * @MethodProperty primitive
	 * @param c 	Coordinate this instance has to be compared with
	 * @return		Boolean indicating whether equal or not
	 */
	public boolean isEqual(Coordinate c) {
		if(c == this) {
			return true;
		}
		
		return ( Double.compare(new Double(this.x), new Double(c.asCartesianCoordinate().getX())) == 0 
			&&   Double.compare(new Double(this.y), new Double(c.asCartesianCoordinate().getY())) == 0
			&&   Double.compare(new Double(this.z), new Double(c.asCartesianCoordinate().getZ())) == 0 );
	}
	
	/**
	 * Doing the same as isEqual therefore forwarding to isEqual
	 * @MethodType comparison
	 * @MethodProperty primitive
	 * @param o 
	 */
	@Override
	public boolean equals(Object o) {
		if( !(o instanceof Coordinate) ) {
			return false;
		}
		return isEqual((Coordinate) o);
	}
	
}
