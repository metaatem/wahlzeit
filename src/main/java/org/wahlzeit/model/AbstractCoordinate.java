/**
 * AbstractCoordinate
 * 
 * 1.0
 * 
 * 20.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCoordinate implements Coordinate {
	
	/**
	 * Converts cylindrical coordinate into cartesian coordinate
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public abstract CartesianCoordinate asCartesianCoordinate();

	
	/**
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCartesianDistance(Coordinate c) {
		assertNotNull(c);
		assertValidCoordinate(c);
		
		return Math.sqrt( Math.pow(c.asCartesianCoordinate().getX() - this.asCartesianCoordinate().getX(), 2) 
				+ Math.pow(c.asCartesianCoordinate().getY() - this.asCartesianCoordinate().getY(), 2) 
				+ Math.pow(c.asCartesianCoordinate().getZ() - this.asCartesianCoordinate().getZ(), 2) );
	}
	
	
	/**
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public abstract CylindricalCoordinate asCylindricalCoordinate();
	
	
	/**
	 * Converts cartesian coordinate into spheric coordinate
	 * See 'Cartesian Coordinates' at https://en.wikipedia.org/wiki/Spherical_coordinate_system
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public abstract SphericCoordinate asSphericCoordinate();
	
	
	/**
	 * Calculates central angle based on longitude and latitude
	 * See https://en.wikipedia.org/wiki/Great-circle_distance
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCentralAngle(Coordinate c) {
		assertNotNull(c);
		assertValidCoordinate(c);
		
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
	 * @throws UnknownCoordinateTypeException 
	 * @throws InvalidCoordinateException 
	 * @throws  
	 * @throws InvalidCoordinateException 
	 */
	public abstract boolean isEqual(Coordinate c);
	
	
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
	
	
	
	/**
	 * @MethodType assertion
	 * @param c coordinate
	 */
	protected void assertValidCoordinate(Coordinate c) {
		
		if(!(c instanceof CartesianCoordinate)
			&& !(c instanceof CylindricalCoordinate)
			&& !(c instanceof SphericCoordinate)){
			throw new IllegalArgumentException("Unknown coordinate-subtype");
		}
	}
	
	/**
	 * @MethodType assertion
	 * @param c
	 */
	protected void assertNotNull(Object c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
	}
	
	
	/**
	 * @MethodType assertion
	 * @param d
	 */
	protected void assertValidDouble(double d) {
		if(d == Double.NaN){
			throw new IllegalArgumentException("Argument is NaN instead of double");
		}
		
		if(d == Double.NEGATIVE_INFINITY) {
			throw new IllegalArgumentException("Argument is negative infinite instead of double");
		}
		
		if(d == Double.POSITIVE_INFINITY) {
			throw new IllegalArgumentException("Argument is positive infinite instead of double");
		}
	}
	
	/**
	 * @MethodType assertion
	 * @param theta
	 */
	protected void assertTheta(double theta) {
		assertValidDouble(theta);
		if( (((-1) * (Math.PI / 2)) > theta) && (theta > (Math.PI / 2)) ) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * @MethodType assertion
	 * @param phi
	 */
	protected void assertPhi(double phi) {
		assertValidDouble(phi);
		if( (((-1) * Math.PI) > phi) && (phi > Math.PI) ) {
			throw new IllegalArgumentException();
		}
	}
	
}
