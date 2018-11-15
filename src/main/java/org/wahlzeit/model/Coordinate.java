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
