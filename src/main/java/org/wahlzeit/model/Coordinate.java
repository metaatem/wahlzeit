package org.wahlzeit.model;

import java.util.ArrayList;

public class Coordinate {
	/**
	 * 
	 */
	private double x;
	private double y;
	private double z;
	
	
	protected Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	protected void setXYZ(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	protected void setX(double x) {
		this.x = x;
	}
	
	protected void setY(double y) {
		this.y = y;
	}
	
	protected void setZ(double z) {
		this.z = z;
	}
	
	protected double[] getXYZ(){
		double[] vector = new double[] {x,y,z};
		return vector;
	}
	
	protected double getX() {
		return this.x;
	}
	
	protected double getY() {
		return this.y;
	}
	
	protected double getZ() {
		return this.z;
	}
	
	
	/**
	 * Gets distance from 'this' coordinate to Coordinate c
	 */
	protected double getDistance(Coordinate c) {
		return Math.sqrt(Math.pow(c.getX() - this.x, 2) 
					+ Math.pow(c.getY() - this.y, 2) 
					+ Math.pow(c.getZ() - this.z, 2) );
	}
	
	/**
	 * 
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
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Coordinate)) {
			return false;
		}
		return isEqual((Coordinate) o);
	}

}
