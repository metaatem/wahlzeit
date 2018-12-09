/**
 * InvalidCoordinateException
 * 
 * 1.0
 * 
 * 08.12.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.exceptions;

import java.util.Map;
import java.util.logging.Logger;

import org.wahlzeit.model.CoordinateType;

public class InvalidCoordinateException extends CoordinateException{
	
	private CoordinateType type;
	private Map<String,Boolean> faults; 
	
	
	public InvalidCoordinateException() {
		super();
		
		logger = Logger.getLogger(InvalidCoordinateException.class.getName());
	}
	
	
	public InvalidCoordinateException(String msg) {
		super(msg);
		
		logger = Logger.getLogger(InvalidCoordinateException.class.getName());
		
		this.logMsg = msg;
	}
	
	
	public InvalidCoordinateException(CoordinateType type, Map<String, Boolean> faults) {
		super();
		
		logger = Logger.getLogger(InvalidCoordinateException.class.getName());
		
		this.type = type;
		this.faults = faults;
		
		switch(type) {
		case CARTESIAN:
			logMsg = "Invalid values x, y, z for coordinate type: " + type + ".";
			break; 
		case SPHERIC:
			logMsg = "Invalid values radius, theta, phi for coordinate type: " + type + ".";
			break;
		case CYLINDRICAL:
			logMsg = "Invalid values radius, phi, zi for coordinate type: " + type + ".";
			break;
		default:
				break;
		}
	}
	
	
	public InvalidCoordinateException(CoordinateType type, Map<String, Boolean> faults, String msg) {
		this(type, faults);
		
		this.logMsg += "\n:: " + msg;
	}

	public CoordinateType getType() {
		return this.type;
	}
	
	public Map<String, Boolean> getFaults(){
		return this.faults;
	}
	
	
}
