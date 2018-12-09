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


import org.wahlzeit.exceptions.CoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateValueException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;
import org.wahlzeit.utils.MetaatemClassesUtil;


public abstract class AbstractCoordinate implements Coordinate {
	
	/**
	 * Converts cylindrical coordinate into cartesian coordinate
	 * @throws InvalidCoordinateValueException 
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public abstract CartesianCoordinate asCartesianCoordinate() throws CoordinateException;

	
	/**
	 * @throws CoordinateException 
	 * @throws InvalidCoordinateValueException 
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCartesianDistance(Coordinate c) throws CoordinateException {
		try {
			MetaatemClassesUtil.assertNotNull(c);
		}catch(IllegalArgumentException ie) {
			UnknownCoordinateTypeException ucte = new UnknownCoordinateTypeException("Null is not a valid coordinate type");
			ucte.logException();
			throw ucte;
		}
		
		MetaatemClassesUtil.assertValidCoordinate(c);
		
		return Math.sqrt( Math.pow(c.asCartesianCoordinate().getX() - this.asCartesianCoordinate().getX(), 2) 
				+ Math.pow(c.asCartesianCoordinate().getY() - this.asCartesianCoordinate().getY(), 2) 
				+ Math.pow(c.asCartesianCoordinate().getZ() - this.asCartesianCoordinate().getZ(), 2) );
	}
	
	
	/**
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public abstract CylindricalCoordinate asCylindricalCoordinate() throws CoordinateException;
	
	
	/**
	 * Converts cartesian coordinate into spheric coordinate
	 * See 'Cartesian Coordinates' at https://en.wikipedia.org/wiki/Spherical_coordinate_system
	 * @throws InvalidCoordinateValueException 
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public abstract SphericCoordinate asSphericCoordinate() throws CoordinateException;
	
	
	/**
	 * Calculates central angle based on longitude and latitude
	 * See https://en.wikipedia.org/wiki/Great-circle_distance
	 * @throws CoordinateException 
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCentralAngle(Coordinate c) throws CoordinateException {
		try {
			MetaatemClassesUtil.assertNotNull(c);
		}catch(IllegalArgumentException ie) {
			UnknownCoordinateTypeException ucte = new UnknownCoordinateTypeException("Null is not a valid coordinate type");
			ucte.logException();
			throw ucte;
		}
		
		MetaatemClassesUtil.assertValidCoordinate(c);
		
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
	 * @throws CoordinateException 
	 * @throws  
	 * @throws InvalidCoordinateException 
	 */
	public abstract boolean isEqual(Coordinate c) throws CoordinateException;
	
	
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
		
		boolean result = false;
		
		try {
			 result = isEqual((Coordinate) o);
		} catch (CoordinateException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	
	
}
