package org.wahlzeit.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.wahlzeit.exceptions.InvalidCoordinateException;
import org.wahlzeit.exceptions.InvalidCoordinateValueException;
import org.wahlzeit.exceptions.UnknownCoordinateTypeException;
import org.wahlzeit.model.CartesianCoordinate;
import org.wahlzeit.model.Coordinate;
import org.wahlzeit.model.CoordinateType;
import org.wahlzeit.model.CylindricalCoordinate;
import org.wahlzeit.model.Mountain;
import org.wahlzeit.model.MountainType;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.SphericCoordinate;

import com.google.appengine.api.datastore.CloudDatastoreRemoteServiceConfig.AppId.Location;

public class MetaatemClassesUtil {
	
	/**
	 * @MethodType assertion
	 * @param d
	 * @return
	 */
	public static boolean checkInvalidDouble(double d) {
		if(d == Double.NaN || d == Double.MAX_VALUE || d == Double.MIN_VALUE) {
			return true;
		}
		return false;
	}
	
	/**
	 * @MethodType assertion
	 * @param c coordinate
	 * @throws InvalidCoordinateException 
	 * @throws UnknownCoordinateTypeException 
	 */
	public static void assertValidCoordinate(Coordinate c) 
			throws InvalidCoordinateException, UnknownCoordinateTypeException {
		
		Map<String, Boolean> faults = new HashMap<String, Boolean>();
		
		InvalidCoordinateException ice;
		
		if(c instanceof CartesianCoordinate) {
			faults.put("x", checkInvalidDouble(((CartesianCoordinate)c).getX()));
			faults.put("y", checkInvalidDouble(((CartesianCoordinate)c).getY()));
			faults.put("z", checkInvalidDouble(((CartesianCoordinate)c).getZ()));
			if(faults.get("x") || faults.get("y") || faults.get("z")) {
				
				ice = new InvalidCoordinateException(CoordinateType.CARTESIAN, faults);
				ice.logException();
				throw ice;
			}
			
		}else if(c instanceof SphericCoordinate) {
			faults.put("radius", checkInvalidDouble(((SphericCoordinate)c).getRadius()));
			faults.put("theta", checkInvalidDouble(((SphericCoordinate)c).getTheta()));
			faults.put("phi", checkInvalidDouble(((SphericCoordinate)c).getPhi()));
			
			if(faults.get("radius") || faults.get("theta") || faults.get("phi")) {
				
				ice = new InvalidCoordinateException(CoordinateType.SPHERIC, faults);
				ice.logException();
				throw ice;
			}
			
		}else if(c instanceof CylindricalCoordinate) {
			faults.put("radius", checkInvalidDouble(((CylindricalCoordinate)c).getRadius()));
			faults.put("phi", checkInvalidDouble(((CylindricalCoordinate)c).getPhi()));
			faults.put("z", checkInvalidDouble(((CylindricalCoordinate)c).getZ()));
			
			if(faults.get("radius") || faults.get("phi") || faults.get("z")) {
				
				ice = new InvalidCoordinateException(CoordinateType.CYLINDRICAL, faults);
				ice.logException();
				throw ice;
			}
			
		}else {
			UnknownCoordinateTypeException ucte = 
					new UnknownCoordinateTypeException("Not a valid subtype of type Coordinate.");
			ucte.logException();
			throw ucte;
		}
	}
	
	/**
	 * @MethodType assertion
	 * @param c coordinate
	 */
	/*protected void assertValidCoordinateType(Coordinate c) {
		
		if(!(c instanceof CartesianCoordinate)
			&& !(c instanceof CylindricalCoordinate)
			&& !(c instanceof SphericCoordinate)){
			throw new UnknownCoordinateTypeException("Unknown coordinate-subtype");
		}
	}*/
	
	/**
	 * @MethodType assertion
	 * @param c
	 * @throws UnknownCoordinateTypeException 
	 */
	public static void assertNotNull(Object c) {
		if(c == null) {
			throw new IllegalArgumentException("Argument must not be null.");
		}
	}
	
	
	/**
	 * @MethodType assertion
	 * @param d
	 * @throws InvalidCoordinateValueException 
	 */
	public static void assertCoordinateValidDouble(double d) throws InvalidCoordinateValueException {
		if(d == Double.NaN){
			InvalidCoordinateValueException icve = 
					new InvalidCoordinateValueException("Argument is NaN instead of double");
			icve.logException();
			throw icve;
		}
		
		if(d == Double.NEGATIVE_INFINITY) {
			InvalidCoordinateValueException icve = 
					new InvalidCoordinateValueException("Argument is negative infinite instead of double");
			icve.logException();
			throw icve;
		}
		
		if(d == Double.POSITIVE_INFINITY) {
			InvalidCoordinateValueException icve = 
					new InvalidCoordinateValueException("Argument is positive infinite instead of double");
			icve.logException();
			throw icve;
		}
	}
	
	/**
	 * @MethodType assertion
	 * @param theta
	 * @throws InvalidCoordinateValueException 
	 */
	public static void assertTheta(double theta) throws InvalidCoordinateValueException {
		assertCoordinateValidDouble(theta);
		if( (((-1) * (Math.PI / 2)) > theta) && (theta > (Math.PI / 2)) ) {
			InvalidCoordinateValueException icve = 
					new InvalidCoordinateValueException("Longitude theta has to be between -PI/2 <= theta <= PI/2 in radiants");
			icve.logException();
			throw icve;
		}
	}
	
	/**
	 * @MethodType assertion
	 * @param phi
	 * @throws InvalidCoordinateValueException 
	 */
	public static void assertPhi(double phi) throws InvalidCoordinateValueException {
		assertCoordinateValidDouble(phi);
		if( (((-1) * Math.PI) > phi) && (phi > Math.PI) ) {
			InvalidCoordinateValueException icve = 
					new InvalidCoordinateValueException("Latitude phi has to be between PI <= phi <= PI");
			icve.logException();
			throw icve;
		}
	}
	
	public static void assertRadius(double radius) throws InvalidCoordinateValueException {
		InvalidCoordinateValueException icve = null;
		
		assertCoordinateValidDouble(radius);
		
		if( radius < 0.0 ) {
			icve = new InvalidCoordinateValueException("Radius must be positive.");
		}
		
		if( !(radius < Double.POSITIVE_INFINITY) ) {
			icve = new InvalidCoordinateValueException("Radius must not be infinite.");
		}
		
		if(icve != null) {
			icve.logException();
			throw icve;
		}
	}
	
	
	
	
	public static void assertMountain(Mountain mountain) {
		assertNotNull(mountain);
		assertNotNull(mountain.getId());
		assertMountainType(mountain.getType());
	}
	
	public static void assertMountainType(MountainType mountainType) {
		assertName(mountainType.getName());
		assertHeight(mountainType.getHeight());
		
		if(mountainType.isSubtype()) {
			assertMountainType(mountainType.getSuperType());
		}
		
		Iterator<MountainType> iterator = mountainType.getSubTypeIterator();
		while(iterator.hasNext()) {
			assertMountainType(iterator.next());
		}
	}
	
	public static void assertName(String name) {
		assertNotNull(name);
		if(name == "" || name.length() > 38) {
			throw new IllegalArgumentException("Invalid mountain name.");
		}
	}
	
	public static void assertHeight(double height) {
		if(height <= 0.0 || height > 8848.0) {
			throw new IllegalArgumentException("Mountain height must be higher than 0.0 and lower than 8848.0.");
		}
	}
	
	
	/**
	 * @MethodType assertion
	 * @param o
	 */
	public static void assertPhotoId(Object o) {
		if(o == null || !(o instanceof PhotoId)) {
			throw new IllegalArgumentException("Object must be of type PhotoId");
		}
	}
	
	
	

}
