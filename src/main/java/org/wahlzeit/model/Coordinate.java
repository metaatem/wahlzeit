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

import org.wahlzeit.exceptions.CoordinateException;

public interface Coordinate {
	CartesianCoordinate asCartesianCoordinate() throws CoordinateException;
	
	double getCartesianDistance(Coordinate c) throws CoordinateException;
	
	CylindricalCoordinate asCylindricalCoordinate() throws CoordinateException;
	
	SphericCoordinate asSphericCoordinate() throws CoordinateException;
	
	double getCentralAngle(Coordinate c) throws CoordinateException;
	
	boolean isEqual(Coordinate c) throws CoordinateException;
	
	boolean equals(Object o);
}
