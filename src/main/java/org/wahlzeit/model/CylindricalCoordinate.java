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

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.exceptions.CoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateValueException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;
import org.wahlzeit.utils.MetaatemClassesUtil;

public class CylindricalCoordinate extends AbstractCoordinate {
	
	/**
	 * HashMap to make coordinate ValueObject shared
	 */
	protected static Map<Integer, CylindricalCoordinate> cs = new HashMap<Integer, CylindricalCoordinate>();
	
	
	/**
	 * Factory method to fetch a CylindricalCoordinate. 
	 * Assertions in to check for preconditions are done here to separate concerns.
	 * @param radius
	 * @param phi
	 * @param z
	 * @return
	 * @throws InvalidCoordinateValueException
	 */
	public static CylindricalCoordinate getInstance(double radius, double phi, double z) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertRadius(radius);
		MetaatemClassesUtil.assertPhi(phi);
		MetaatemClassesUtil.assertCoordinateValidDouble(z);
		
		return doGetInstance(radius, phi, z);
	}
	
	/**
	 * Actually fetches the CylindricalCoordinate from the central HashMap or creates a new one
	 * Returns the queried CylindricalCoordinate in all cases.
	 * @MethodProperty primitive
	 * @param radius
	 * @param phi
	 * @param z
	 * @return
	 */
	private static CylindricalCoordinate doGetInstance(double radius, double phi, double z) {
		CylindricalCoordinate c = new CylindricalCoordinate(radius, phi, z);
		int hash = c.hashCode();
		c = cs.get(hash);
		if(c == null) {
			synchronized(cs) {
				c = cs.get(hash);
				if(c == null) {
					c = new CylindricalCoordinate(radius, phi, z);
					cs.put(hash, c);
				}
			}
		}
		return c;
	}
	
	/**
	 * Cylindrical coordinate
	 * phi - azimuth signed angle measured from the azimuth reference direction to
	 *       the orthogonal projection of the line segment OP on the reference plane 
	 *       (associated with latitude / geographische Laenge )
	 * radius - distance to point in xy-plane
	 * z - height of the point
	 */
	private final double radius;
	private final double phi;
	private final double z;
	
	
	
	/**
	 * Constructor
	 * @param radius
	 * @param phi
	 * @param z
	 * @throws InvalidCoordinateValueException 
	 */
	private CylindricalCoordinate(double radius, double phi, double z) {
		this.phi = phi;
		this.radius = radius;
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
		return CartesianCoordinate.getInstance(this.radius * Math.cos(this.phi),
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
		return SphericCoordinate.getInstance( Math.sqrt(Math.pow(this.radius, 2) + Math.pow(this.z, 2)),
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
		
		return c == this;
	}
	
	
	/**
	 * Obvious
	 */
	@Override
	public String toString() {
		return getClass().getName() + "@" + "{x: " + this.radius + ", y: " + this.phi + ", z: " + this.z + "}";
	}
	
	/**
	 * Obvious
	 */
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	/**
	 * Obvious
	 */
	@Override
	public CylindricalCoordinate clone() {
		return this;
	}
	
}
