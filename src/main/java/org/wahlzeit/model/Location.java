package org.wahlzeit.model;

public class Location {

	
	protected Coordinate coordinate;
	
	/**
	 * Constructor initializing the coordinate variable
	 * @param coordinate	Coordinate pinpointing location
	 */
	protected Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	/**
	 * Calculates distance from this Location to the Location l
	 * @param ll	Location the distance is calculated to 
	 * @return 		Double for Calculated distance
	 */
	protected double getDistance(Location ll) {
		return this.coordinate.getDistance(ll.coordinate);
	}
	
	/**
	 * Comparing this coordinate with another coordinate c 
	 * @methodtype comparison
	 * @methodproperty regular
	 * @param ll	Location this instance has to be compared with
	 * @return		Boolean indicating whether equal or not
	 */
	protected boolean isEqual(Location ll) {
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
		
		return isEqual((Location) o);
	}
	
}
