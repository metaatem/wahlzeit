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

import org.wahlzeit.exceptions.CoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateValueException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;
import org.wahlzeit.utils.MetaatemClassesUtil;

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
	 * @throws InvalidCoordinateValueException 
	 */
	public SphericCoordinate(double radius, double theta, double phi) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertRadius(radius);
		MetaatemClassesUtil.assertTheta(theta);
		MetaatemClassesUtil.assertPhi(phi);
		
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
	 * @throws InvalidCoordinateValueException 
	 */
	public void setPhi(double phi) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertPhi(phi);
		
		this.phi = phi;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param y		y-coordinate
	 * @throws InvalidCoordinateValueException 
	 */
	public void setTheta(double theta) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertTheta(theta);
		
		this.theta = theta;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param z		z-coordinate
	 * @throws InvalidCoordinateValueException 
	 */
	public void setRadius(double radius) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertRadius(radius);
		
		this.radius = radius;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	x-coordinate
	 */
	public double getPhi() {
		return this.phi;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	y-coordinate
	 */
	public double getTheta() {
		return this.theta;
	}
	
	/**
	 * @methodtype get 
	 * @methodproperty primitive
	 * @return	z-coordinate
	 */
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * Converts spheric coordinate into cartesian coordinate
	 * @throws InvalidCoordinateValueException 
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CartesianCoordinate asCartesianCoordinate() throws InvalidCoordinateValueException {
		return basicAsCartesianCoordinate();
	}
	
	/**
	 * @throws InvalidCoordinateValueException 
	 * @MethodProperty primitive
	 */
	private CartesianCoordinate basicAsCartesianCoordinate() throws InvalidCoordinateValueException {
		return new CartesianCoordinate( (this.radius * Math.sin(this.theta) * Math.cos(this.phi)),
				(this.radius * Math.sin(this.theta) * Math.sin(this.phi)),
				(this.radius * Math.cos(this.theta))  );
	}
	
	/**
	 * Converts spheric coordinate into cylindrical coordinate
	 * @throws InvalidCoordinateValueException 
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CylindricalCoordinate asCylindricalCoordinate() throws InvalidCoordinateValueException {
		return basicAsCylindricalCoordinate();
	}
	
	/**
	 * @throws InvalidCoordinateValueException 
	 * @MethodProperty primitive
	 */
	private CylindricalCoordinate basicAsCylindricalCoordinate() throws InvalidCoordinateValueException {
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
	 * @throws UnknownCoordinateTypeException 
	 * @throws InvalidCoordinateException 
	 */
	public boolean isEqual(Coordinate c) throws CoordinateException {
		try {
			MetaatemClassesUtil.assertNotNull(c);
		}catch(IllegalArgumentException ie) {
			UnknownCoordinateTypeException ucte = new UnknownCoordinateTypeException("Null is not a valid coordinate type");
			ucte.logException();
			throw ucte;
		}
		MetaatemClassesUtil.assertValidCoordinate(c);
		
		return ( Double.compare(new Double(this.phi), new Double(c.asSphericCoordinate().getPhi())) == 0 
			&&   Double.compare(new Double(this.theta), new Double(c.asSphericCoordinate().getTheta())) == 0
			&&   Double.compare(new Double(this.radius), new Double(c.asSphericCoordinate().getRadius())) == 0 );
	}
	
}
