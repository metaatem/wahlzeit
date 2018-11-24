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

public abstract class AbstractCoordinate implements Coordinate{
	
	/**
	 * Converts cylindrical coordinate into cartesian coordinate
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		return basicAsCartesianCoordinate();
	}
	
	protected abstract CartesianCoordinate basicAsCartesianCoordinate();

	
	/**
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCartesianDistance(Coordinate c) {
		return doGetCartesianDistance(c);
	}
	
	/**
	 * @MethodProperty primitive
	 * @param c
	 * @return
	 */
	protected double doGetCartesianDistance(Coordinate c) {
		return Math.sqrt( Math.pow(c.asCartesianCoordinate().getX() - this.asCartesianCoordinate().getX(), 2) 
						+ Math.pow(c.asCartesianCoordinate().getY() - this.asCartesianCoordinate().getY(), 2) 
						+ Math.pow(c.asCartesianCoordinate().getZ() - this.asCartesianCoordinate().getZ(), 2) );
	}
	
	
	/**
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CylindricalCoordinate asCylindricalCoordinate() {
		return basicAsCylindricalCoordinate();
	}
	
	protected abstract CylindricalCoordinate basicAsCylindricalCoordinate();
	
	
	/**
	 * Converts cartesian coordinate into spheric coordinate
	 * See 'Cartesian Coordinates' at https://en.wikipedia.org/wiki/Spherical_coordinate_system
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public SphericCoordinate asSphericCoordinate() {
		return basicAsSphericCoordinate();
	}
	
	protected abstract SphericCoordinate basicAsSphericCoordinate();
	
	
	/**
	 * Calculates central angle based on longitude and latitude
	 * See https://en.wikipedia.org/wiki/Great-circle_distance
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCentralAngle(Coordinate c) {
		return doGetCentralAngle(c);
	}
	
	/**
	 * @MethodProperty primitive
	 */
	protected double doGetCentralAngle(Coordinate c) {
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
	 */
	public boolean isEqual(Coordinate c) {
		if(c == this) {
			return true;
		}
		
		return basicIsEqual(c);
	}
	
	protected abstract boolean basicIsEqual(Coordinate c);
	
	
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
	
}
