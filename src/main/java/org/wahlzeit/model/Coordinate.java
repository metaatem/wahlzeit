/**
 * Coordinate
 * 
 * 1.0
 * 
 * 15.11.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

public interface Coordinate {
	CartesianCoordinate asCartesianCoordinate();
	
	double getCartesianDistance(Coordinate c);
	
	CylindricalCoordinate asCylindricalCoordinate();
	
	SphericCoordinate asSphericCoordinate();
	
	double getCentralAngle(Coordinate c);
	
	boolean isEqual(Coordinate c);
	
	boolean equals(Object o);
}
