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

import org.wahlzeit.exceptions.CoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateValueException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;
import org.wahlzeit.utils.MetaatemClassesUtil;

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
	 * @throws InvalidCoordinateValueException 
	 */
	public CartesianCoordinate(double x, double y, double z) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertCoordinateValidDouble(x);
		MetaatemClassesUtil.assertCoordinateValidDouble(y);
		MetaatemClassesUtil.assertCoordinateValidDouble(z);
		
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
	 * @throws InvalidCoordinateValueException 
	 */
	public void setXYZ(double x, double y, double z) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertCoordinateValidDouble(x);
		MetaatemClassesUtil.assertCoordinateValidDouble(y);
		MetaatemClassesUtil.assertCoordinateValidDouble(z);
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Setter for x-coordinate
	 * @methodtype set
	 * @methodproperty primitive
	 * @param x		x-coordinate
	 * @throws InvalidCoordinateValueException 
	 */
	public void setX(double x) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertCoordinateValidDouble(x);
		
		this.x = x;
	}
	
	/**
	 * Setter for y-coordinate
	 * @methodtype set
	 * @methodproperty primitive
	 * @param y		y-coordinate
	 * @throws InvalidCoordinateValueException 
	 */
	public void setY(double y) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertCoordinateValidDouble(y);
		
		this.y = y;
	}
	
	/**
	 * Setter for z-coordinate
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
	 * Getter to get x,y,z coordinates in one go
	 * @methodtype get
	 * @methodproperty primitive
	 * @return		Array containing x,y,z
	 */
	public double[] getXYZ(){
		double[] vector = new double[] {x,y,z};
		return vector;
	}
	
	/**
	 * Getter for x-coordinate
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	x-coordinate
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Getter for x-coordinate
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	y-coordinate
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * Getter for x-coordinate
	 * @MethodType get 
	 * @MethodProperty primitive
	 * @return	z-coordinate
	 */
	public double getZ() {
		return this.z;
	}
	
	
	/**
	 * Trivial conversion
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	
	/**
	 * Converts cartesian coordinate into cylindrical coordinate
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
	protected CylindricalCoordinate basicAsCylindricalCoordinate() throws InvalidCoordinateValueException {
		return new CylindricalCoordinate( Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)),
				Math.atan2(this.y, this.x), this.z);	
	}

	/**
	 * Converts cartesian coordinate into spheric coordinate
	 * See 'Cartesian Coordinates' at https://en.wikipedia.org/wiki/Spherical_coordinate_system
	 * @throws InvalidCoordinateValueException 
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public SphericCoordinate asSphericCoordinate() throws InvalidCoordinateValueException {
		return basicAsSphericCoordinate();
	}
	
	/**
	 * @throws InvalidCoordinateValueException 
	 * @MethodProperty primitive
	 */
	protected SphericCoordinate basicAsSphericCoordinate() throws InvalidCoordinateValueException {
		return new SphericCoordinate( Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2)),
				Math.acos( this.z / Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2))),
				Math.atan2(this.y, this.x)  );
	}

	/**
	 * Comparing this coordinate with another coordinate c 
	 * @MethodType comparison
	 * @MethodProperty primitive
	 * @param c 	Coordinate this instance has to be compared with
	 * @return		Boolean indicating whether equal or not
	 * @throws CoordinateException 
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
		
		return ( Double.compare(new Double(this.x), new Double(c.asCartesianCoordinate().getX())) == 0 
			&&   Double.compare(new Double(this.y), new Double(c.asCartesianCoordinate().getY())) == 0
			&&   Double.compare(new Double(this.z), new Double(c.asCartesianCoordinate().getZ())) == 0 );
	}
	
}
