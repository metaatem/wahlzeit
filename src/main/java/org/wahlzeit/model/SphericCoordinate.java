package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{
	
	/**
	 * Spheric coordinate according to ISO convention used in physics
	 * See https://en.wikipedia.org/wiki/Spherical_coordinate_system
	 * phi - azimuth signed angle measured from the azimuth reference direction to
	 *       the orthogonal projection of the line segment OP on the reference plane
	 * theta - inclination, the angle between the zenith direction and the OP line
	 * radius as euclidean distance from origin O to point P
	 */
	private double phi;
	private double theta;
	private double radius;
	
	/**
	 * Constructor for Coordinate class
	 * 
	 * @param x		x-coordinate
	 * @param y		y-coordinate
	 * @param z		z-coordinate
	 */
	protected SphericCoordinate(double radius, double theta, double phi) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}
	
	/**
	 * Helper handing back properties as String
	 * @MethodType get
	 * @MethodProperty primitive
	 * @return 
	 */
	public String propertiesAsString() {
		return Double.toString(radius) + "\n" + Double.toString(theta) + "\n" + Double.toString(phi);
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param x		x-coordinate
	 */
	protected void setPhi(double phi) {
		this.phi = phi;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param y		y-coordinate
	 */
	protected void setTheta(double theta) {
		this.theta = theta;
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 * @param z		z-coordinate
	 */
	protected void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	x-coordinate
	 */
	protected double getPhi() {
		return this.phi;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 * @return	y-coordinate
	 */
	protected double getTheta() {
		return this.theta;
	}
	
	/**
	 * @methodtype get 
	 * @methodproperty primitive
	 * @return	z-coordinate
	 */
	protected double getRadius() {
		return this.radius;
	}
	
	/**
	 * Converts spheric coordinate into cartesian coordinate
	 * See 'Cartesian Coordinates' at https://en.wikipedia.org/wiki/Spherical_coordinate_system
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		return new CartesianCoordinate( (this.radius * Math.sin(this.theta) * Math.cos(this.phi)),
										(this.radius * Math.sin(this.theta) * Math.sin(this.phi)),
										(this.radius * Math.cos(this.theta))  );
	}
	
	/**
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCartesianDistance(Coordinate c) {
		return Math.sqrt( Math.pow(c.asCartesianCoordinate().getX() - this.asCartesianCoordinate().getX(), 2) 
						+ Math.pow(c.asCartesianCoordinate().getY() - this.asCartesianCoordinate().getY(), 2) 
						+ Math.pow(c.asCartesianCoordinate().getZ() - this.asCartesianCoordinate().getZ(), 2) );
	}
	
	/**
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public CylindricalCoordinate asCylindricalCoordinate() {
		return new CylindricalCoordinate( (this.radius * Math.sin(this.theta)),
						this.phi, (this.radius * Math.cos(this.theta)) );
	}

	/**
	 * @MethodType conversion
	 * @MethodProperty primitive
	 */
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}
	
	/**
	 * Calculates central angle based on longitude and latitude
	 * See https://en.wikipedia.org/wiki/Great-circle_distance 
	 * 
	 * @MethodType get
	 * @MethodProperty primitive
	 */
	public double getCentralAngle(Coordinate c) {
		double lat1 = this.theta;
		double long1 = this.phi;
		double lat2 = c.asSphericCoordinate().getTheta();
		double long2 = c.asSphericCoordinate().getPhi();
		
		return Math.acos(Math.sin(lat1) * Math.sin(lat2)
					+ Math.cos(lat1) * Math.cos(lat2) * Math.cos(Math.abs(long1 - long2)));
	}
	
	/**
	 * @MethodType comparison
	 * @MethodProperty primitive
	 */
	public boolean isEqual(Coordinate c) {
		if(c == this) {
			return true;
		}
		return ( Double.compare(new Double(this.phi), new Double(c.asSphericCoordinate().getPhi())) == 0 
			&&   Double.compare(new Double(this.theta), new Double(c.asSphericCoordinate().getTheta())) == 0
			&&   Double.compare(new Double(this.radius), new Double(c.asSphericCoordinate().getRadius())) == 0 );
	}
	
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
