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

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.exceptions.CoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateValueException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;
import org.wahlzeit.utils.DesignPattern;
import org.wahlzeit.utils.MetaatemClassesUtil;

@DesignPattern(name = "Value Object", participants = {""})
@DesignPattern(name = "Template Method", participants = {"Concrete Class"})
@DesignPattern(name = "Flyweight", participants = {"Concrete Flyweight"})
public class SphericCoordinate extends AbstractCoordinate{
	
	/**
	 * Factory method to fetch a SphericCoordinate. 
	 * Assertions in to check for preconditions are done here to separate concerns.
	 * @param radius
	 * @param phi
	 * @param z
	 * @return
	 * @throws InvalidCoordinateValueException
	 */
	public static SphericCoordinate getInstance(double radius, double theta, double phi) throws InvalidCoordinateValueException {
		MetaatemClassesUtil.assertRadius(radius);
		MetaatemClassesUtil.assertTheta(theta);
		MetaatemClassesUtil.assertPhi(phi);
		
		return doGetInstance(radius, theta, phi);
	}
	
	/**
	 * Actually fetches the SphericCoordinate from the central HashMap or creates a new one
	 * Returns the queried SphericCoordinate in all cases.
	 * @MethodProperty primitive
	 * @param radius
	 * @param phi
	 * @param z
	 * @return
	 */
	private static SphericCoordinate doGetInstance(double radius, double theta, double phi) {
		Coordinate c = new SphericCoordinate(radius, theta, phi);
		int hash = c.hashCode();
		c = cs.get(hash);
		if(c == null) {
			synchronized(cs) {
				c = cs.get(hash);
				if(c == null) {
					c = new SphericCoordinate(radius, theta, phi);
					cs.put(hash, c);
				}
			}
		}
		return (SphericCoordinate) c;
	}
	
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
	private final double phi;
	private final double theta;
	private final double radius;
	
	/**
	 * Constructor for Coordinate class
	 * 
	 * @param x		x-coordinate
	 * @param y		y-coordinate
	 * @param z		z-coordinate
	 * @throws InvalidCoordinateValueException 
	 */
	private SphericCoordinate(double radius, double theta, double phi) {
		this.phi = phi;
		this.theta = theta;
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
		return CartesianCoordinate.getInstance( (this.radius * Math.sin(this.theta) * Math.cos(this.phi)),
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
		return CylindricalCoordinate.getInstance( (this.radius * Math.sin(this.theta)),
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
		
		return c == this;
	}
	
	/**
	 * Obvious
	 */
	@Override
	public String toString() {
		return getClass().getName() + "@" + "{x: " + this.radius + ", y: " + this.theta + ", z: " + this.phi + "}";
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
	public SphericCoordinate clone() {
		return this;
	}
	
}
