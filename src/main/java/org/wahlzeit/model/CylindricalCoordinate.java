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
	
	/**
	 * Cylindrical coordinate
	 * phi - azimuth signed angle measured from the azimuth reference direction to
	 *       the orthogonal projection of the line segment OP on the reference plane 
	 *       (associated with latitude / geographische Laenge )
	 * radius - distance to point in xy-plane
	 * z - height of the point
	 */
	
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
		assertValidDouble(radius);
		assertPhi(phi);
		assertValidDouble(z);
		
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
		assertPhi(phi);
		
		this.phi = phi;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param y		y-coordinate
	 */
	protected void setRadius(double radius) {
		assertValidDouble(radius);
		
		this.radius = radius;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param z		z-coordinate
	 */
	protected void setZ(double z) {
		assertValidDouble(z);
		
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
		return basicAsCartesianCoordinate();
	}
	
	/**
	 * @MethodProperty primitive
	 */
	private CartesianCoordinate basicAsCartesianCoordinate() {
		return new CartesianCoordinate(this.radius * Math.cos(this.phi),
				this.radius * Math.sin(this.phi), this.z);
	}
	
	/**
	 * Trivial conversion
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CylindricalCoordinate asCylindricalCoordinate() {
		return this;
	}
	
	/**
	 * @MethodProperty primitive
	 */
	public SphericCoordinate asSphericCoordinate() {
		return basicAsSphericCoordinate();
	}
	
	private SphericCoordinate basicAsSphericCoordinate() {
		return new SphericCoordinate( Math.sqrt(Math.pow(this.radius, 2) + Math.pow(this.z, 2)),
				Math.atan2(this.radius, this.z), this.phi);
	}

	/**
	 * Comparing this coordinate with another coordinate c 
	 * @MethodType comparison
	 * @MethodProperty primitive
	 * @param c 	Coordinate this instance has to be compared with
	 * @return		Boolean indicating whether equal or not
	 */
	public boolean isEqual(Coordinate c) {
		assertNotNull(c);
		assertValidCoordinate(c);
		
		return ( Double.compare(new Double(this.radius), new Double(c.asCylindricalCoordinate().getRadius())) == 0 
			&&   Double.compare(new Double(this.phi), new Double(c.asCylindricalCoordinate().getPhi())) == 0
			&&   Double.compare(new Double(this.z), new Double(c.asCylindricalCoordinate().getZ())) == 0 );
	}
	
}
