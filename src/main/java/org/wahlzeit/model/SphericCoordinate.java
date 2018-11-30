/**
 * SphericCoordinate
 * 
 * 1.0
 * 
 * 15.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate{
	
	/**
	 * Spheric coordinate according to ISO convention used in physics
	 * See https://en.wikipedia.org/wiki/Spherical_coordinate_system
	 * phi - azimuth signed angle measured from the azimuth reference direction to
	 *       the orthogonal projection of the line segment OP on the reference plane 
	 *       (associated with latitude / geographische Laenge )
	 * theta - inclination, the angle between the zenith direction and the OP line
	 * 		 (associated with longitude/ geographische Breite )
	 * radius - as euclidean distance from origin origin to point P
	 */
	private double phi;
	private double theta;
	private double radius;
	
	/**
	 * Constructor for Coordinate class
	 * 
	 * @param x		x-coordinate
	 * @param y		y-coordinate
	 * @param z		z-coordinate
	 */
	protected SphericCoordinate(double radius, double theta, double phi) {
		assertValidDouble(radius);
		assertTheta(theta);
		assertPhi(phi);
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}
	
	/**
	 * Helper handing back properties as String
	 * @MethodType get
	 * @MethodProperty primitive
	 * @return 
	 */
	public String propertiesAsString() {
		return Double.toString(radius) + "\n" + Double.toString(theta) + "\n" + Double.toString(phi);
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
	protected void setTheta(double theta) {
		assertTheta(theta);
		
		this.theta = theta;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param z		z-coordinate
	 */
	protected void setRadius(double radius) {
		assertValidDouble(radius);
		
		this.radius = radius;
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
	protected double getTheta() {
		return this.theta;
	}
	
	/**
	 * @methodtype get 
	 * @methodproperty primitive
	 * @return	z-coordinate
	 */
	protected double getRadius() {
		return this.radius;
	}
	
	/**
	 * Converts spheric coordinate into cartesian coordinate
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
		return new CartesianCoordinate( (this.radius * Math.sin(this.theta) * Math.cos(this.phi)),
				(this.radius * Math.sin(this.theta) * Math.sin(this.phi)),
				(this.radius * Math.cos(this.theta))  );
	}
	
	/**
	 * Converts spheric coordinate into cylindrical coordinate
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CylindricalCoordinate asCylindricalCoordinate() {
		return basicAsCylindricalCoordinate();
	}
	
	/**
	 * @MethodProperty primitive
	 */
	private CylindricalCoordinate basicAsCylindricalCoordinate() {
		return new CylindricalCoordinate( (this.radius * Math.sin(this.theta)),
				this.phi, (this.radius * Math.cos(this.theta)) );
	}

	/**
	 * Trivial conversion
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public SphericCoordinate asSphericCoordinate() {
		return this;
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
		
		return ( Double.compare(new Double(this.phi), new Double(c.asSphericCoordinate().getPhi())) == 0 
			&&   Double.compare(new Double(this.theta), new Double(c.asSphericCoordinate().getTheta())) == 0
			&&   Double.compare(new Double(this.radius), new Double(c.asSphericCoordinate().getRadius())) == 0 );
	}
	
}
