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

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.exceptions.CoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateValueException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;
import org.wahlzeit.utils.MetaatemClassesUtil;

public class CartesianCoordinate extends AbstractCoordinate {
	
	protected static Map<Integer, CartesianCoordinate> cs = new HashMap<Integer, CartesianCoordinate>();
	
	
	public static CartesianCoordinate getInstance(double x, double y, double z) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertCoordinateValidDouble(x);
		MetaatemClassesUtil.assertCoordinateValidDouble(y);
		MetaatemClassesUtil.assertCoordinateValidDouble(z);
		
		return doGetInstance(x, y, z);
	}
	
	private static CartesianCoordinate doGetInstance(double x, double y, double z) {
		CartesianCoordinate c = new CartesianCoordinate(x, y, z);
		int hash = c.hashCode();
		c = cs.get(hash);
		if(c == null) {
			synchronized(cs) {
				c = cs.get(hash);
				if(c == null) {
					c = new CartesianCoordinate(x,y,z);
					cs.put(hash, c);
				}
			}
		}
		return c;
	}
	
	/**
     * Coordinate values
	 */
	private final double x;
	private final double y;
	private final double z;
	
	
	
	/**
	 * Constructor for Coordinate class
	 * 
	 * @param x		x-coordinate
	 * @param y		y-coordinate
	 * @param z		z-coordinate
	 * @throws InvalidCoordinateValueException 
	 */
	private CartesianCoordinate(double x, double y, double z)  {
		this.x = x;
		this.y = y;
		this.z = z;
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
		return CylindricalCoordinate.getInstance( Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)),
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
		return SphericCoordinate.getInstance( Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2)),
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
		
		return c == this;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "@" + "{x: " + this.x + ", y: " + this.y + ", z: " + this.z + "}";
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	@Override
	public CartesianCoordinate clone() {
		return this;
	}
	
}
