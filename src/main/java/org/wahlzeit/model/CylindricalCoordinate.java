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

import org.wahlzeit.exceptions.CoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateValueException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;
import org.wahlzeit.utils.MetaatemClassesUtil;

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
	 * @throws InvalidCoordinateValueException 
	 */
	public CylindricalCoordinate(double radius, double phi, double z) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertRadius(radius);
		MetaatemClassesUtil.assertPhi(phi);
		MetaatemClassesUtil.assertCoordinateValidDouble(z);
		
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
	public void setRadius(double radius) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertRadius(radius);
		
		this.radius = radius;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param z		z-coordinate
	 * @throws InvalidCoordinateValueException 
	 */
	public void setZ(double z) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertCoordinateValidDouble(z);
		
		this.z = z;
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
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * @methodtype get 
	 * @methodproperty primitive
	 * @return	z-coordinate
	 */
	public double getZ() {
		return this.z;
	}
	
	
	/**
	 * Converts cylindrical coordinate into cartesian coordinate
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
	 * @throws InvalidCoordinateValueException 
	 * @MethodProperty primitive
	 */
	public SphericCoordinate asSphericCoordinate() throws InvalidCoordinateValueException {
		return basicAsSphericCoordinate();
	}
	
	private SphericCoordinate basicAsSphericCoordinate() throws InvalidCoordinateValueException {
		return new SphericCoordinate( Math.sqrt(Math.pow(this.radius, 2) + Math.pow(this.z, 2)),
				Math.atan2(this.radius, this.z), this.phi);
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
		
		return ( Double.compare(new Double(this.radius), new Double(c.asCylindricalCoordinate().getRadius())) == 0 
			&&   Double.compare(new Double(this.phi), new Double(c.asCylindricalCoordinate().getPhi())) == 0
			&&   Double.compare(new Double(this.z), new Double(c.asCylindricalCoordinate().getZ())) == 0 );
	}
	
}
