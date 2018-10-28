package org.wahlzeit.model;

import java.util.ArrayList;

public class Coordinate {
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * Constructor for Coordinate class
	 * 
	 * @param x		x-coordinate
	 * @param y		y-coordinate
	 * @param z		z-coordinate
	 */
	protected Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Setter for Coordinate class to set x,y,z in one go.
	 * 
	 * @param x		x-coordinate
	 * @param y		y-coordinate
	 * @param z		z-coordinate
	 */
	protected void setXYZ(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Setter for x-coordinate
	 * @param x		x-coordinate
	 */
	protected void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Setter for y-coordinate
	 * @param y		y-coordinate
	 */
	protected void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Setter for z-coordinate
	 * @param z		z-coordinate
	 */
	protected void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * Getter to get x,y,z coordinates in one go
	 * @return		Array containing x,y,z
	 */
	protected double[] getXYZ(){
		double[] vector = new double[] {x,y,z};
		return vector;
	}
	
	/**
	 * Getter for x-coordinate
	 * @return	x-coordinate
	 */
	protected double getX() {
		return this.x;
	}
	
	/**
	 * Getter for x-coordinate
	 * @return	y-coordinate
	 */
	protected double getY() {
		return this.y;
	}
	
	/**
	 * Getter for x-coordinate
	 * @return	z-coordinate
	 */
	protected double getZ() {
		return this.z;
	}
	
	
	/**
	 * Calculates distance from this coordinate to the coordinate c
	 * @param c		Coordinate the distance is calculated to 
	 * @return 		Calculated distance
	 */
	protected double getDistance(Coordinate c) {
		return Math.sqrt(Math.pow(c.getX() - this.x, 2) 
					+ Math.pow(c.getY() - this.y, 2) 
					+ Math.pow(c.getZ() - this.z, 2) );
	}
	
	/**
	 * Comparing this coordinate with another coordinate c 
	 * @param c 	Coordinate this instance has to be compared with
	 * @return		Boolean indicating whether equal or not
	 */
	protected boolean isEqual(Coordinate c) {
		if(c == this) {
			return true;
		}
		
		return ( Double.compare(new Double(this.x), new Double(c.getX())) == 0 
			&&   Double.compare(new Double(this.y), new Double(c.getY())) == 0
			&&   Double.compare(new Double(this.z), new Double(c.getZ())) == 0 );
	}
	
	/**
	 * Doing the same as isEqual therefore forwarding to isEqual
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
