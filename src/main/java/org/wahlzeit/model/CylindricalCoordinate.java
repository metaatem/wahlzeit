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

public class CylindricalCoordinate extends AbstractCoordinate {
	
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
	 * @MethodProperty primitive
	 */
	protected CartesianCoordinate basicAsCartesianCoordinate() {
		return new CartesianCoordinate(this.radius * Math.cos(this.phi),
				this.radius * Math.sin(this.phi), this.z);	
	}
	
	/**
	 * @MethodProperty primitive
	 */
	protected CylindricalCoordinate basicAsCylindricalCoordinate() {
		return this;
	}
	
	/**
	 * @MethodProperty primitive
	 */
	protected SphericCoordinate basicAsSphericCoordinate() {
		return new SphericCoordinate( Math.sqrt(Math.pow(this.radius, 2) + Math.pow(this.z, 2)),
				Math.atan2(this.radius, this.z), this.phi);
	}

	/**
	 * @MethodProperty primitive
	 */
	protected boolean basicIsEqual(Coordinate c) {
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
