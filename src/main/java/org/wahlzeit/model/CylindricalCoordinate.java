/**
 * CylindricalCoordinateTest
 * 
 * 1.0
 * 
 * 15.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

public class CylindricalCoordinate implements Coordinate{
	
	private double radius;
	private double phi;
	private double z;
	
	
	
	/**
	 * Constructor
	 * @param radius
	 * @param phi
	 * @param z
	 */
	public CylindricalCoordinate(double radius, double phi, double z) {
		this.phi = phi;
		this.radius = radius;
		this.z = z;
	}
	
	/**
	 * Helper handing back properties as String
	 * @MethodType get
	 * @MethodProperty primitive
	 * @return 
	 */
	public String propertiesAsString() {
		return Double.toString(radius) + "\n" + Double.toString(phi) + "\n" + Double.toString(z);
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param x		x-coordinate
	 */
	protected void setPhi(double phi) {
		this.phi = phi;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param y		y-coordinate
	 */
	protected void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param z		z-coordinate
	 */
	protected void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	x-coordinate
	 */
	protected double getPhi() {
		return this.phi;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	y-coordinate
	 */
	protected double getRadius() {
		return this.radius;
	}
	
	/**
	 * @methodtype get 
	 * @methodproperty primitive
	 * @return	z-coordinate
	 */
	protected double getZ() {
		return this.z;
	}
	
	
	/**
	 * Converts cylindrical coordinate into cartesian coordinate
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		return new CartesianCoordinate(this.radius * Math.cos(this.phi),
						this.radius * Math.sin(this.phi), this.z);	
	}

	/**
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCartesianDistance(Coordinate c) {
		return Math.sqrt( Math.pow(c.asCartesianCoordinate().getX() - this.asCartesianCoordinate().getX(), 2) 
						+ Math.pow(c.asCartesianCoordinate().getY() - this.asCartesianCoordinate().getY(), 2) 
						+ Math.pow(c.asCartesianCoordinate().getZ() - this.asCartesianCoordinate().getZ(), 2) );
	}
	
	/**
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CylindricalCoordinate asCylindricalCoordinate() {
		return this;
	}
	
	/**
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public SphericCoordinate asSphericCoordinate() {
		return new SphericCoordinate( Math.sqrt(Math.pow(this.radius, 2) + Math.pow(this.z, 2)),
						Math.atan2(this.radius, this.z), this.phi);
	}

	
	/**
	 * Calculates central angle based on longitude and latitude
	 * See https://en.wikipedia.org/wiki/Great-circle_distance 
	 * 
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
		
		return ( Double.compare(new Double(this.radius), new Double(c.asCylindricalCoordinate().getRadius())) == 0 
			&&   Double.compare(new Double(this.phi), new Double(c.asCylindricalCoordinate().getPhi())) == 0
			&&   Double.compare(new Double(this.z), new Double(c.asCylindricalCoordinate().getZ())) == 0 );
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
