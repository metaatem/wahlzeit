/**
 * Location
 * 
 * 1.0
 * 
 * 28.10.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.model;

import org.wahlzeit.exceptions.CoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;
import org.wahlzeit.utils.MetaatemClassesUtil;

public class Location {

	
	protected CartesianCoordinate coordinate;
	
	/**
	 * Constructor initializing the coordinate variable
	 * @param coordinate	Coordinate pinpointing location
	 * @throws UnknownCoordinateTypeException 
	 * @throws InvalidCoordinateException 
	 */
	protected Location(CartesianCoordinate coordinate)
			throws InvalidCoordinateException, UnknownCoordinateTypeException {
		
		MetaatemClassesUtil.assertValidCoordinate(coordinate);
		
		this.coordinate = coordinate;
	}
	
	/**
	 * Calculates distance from this Location to the Location l
	 * @param ll	Location the distance is calculated to 
	 * @return 		Double for Calculated distance
	 * @throws CoordinateException 
	 */
	protected double getDistance(Location ll) throws CoordinateException {
		return this.coordinate.getCartesianDistance(ll.coordinate);
	}
	
	/**
	 * Comparing this coordinate with another coordinate c 
	 * @methodtype comparison
	 * @methodproperty regular
	 * @param ll	Location this instance has to be compared with
	 * @return		Boolean indicating whether equal or not
	 * @throws CoordinateException 
	 */
	protected boolean isEqual(Location ll) throws CoordinateException {
		if(ll == this) {
			return true;
		}
		
		return (this.coordinate).isEqual(ll.coordinate);
	}
	
	/**
	 * Doing the same as isEqual therefore forwarding to isEqual
	 * @methodtype comparison
	 * @methodproperty regular
	 * @param o 	Object to be compared with
	 */
	@Override
	public boolean equals(Object o) {
		if( !(o instanceof Location) ) {
			return false;
		}
		
		boolean result = false;
		
		try {
			result = isEqual((Location) o);
		} catch (CoordinateException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
