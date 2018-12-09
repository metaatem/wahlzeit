/**
 * InvalidCoordinateValueException
 * 
 * 1.0
 * 
 * 08.12.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.exceptions;

import java.util.logging.Logger;

public class InvalidCoordinateValueException extends InvalidCoordinateException {
	
	public InvalidCoordinateValueException() {
		super();
	}
	
	public InvalidCoordinateValueException(String msg) {
		super(msg);
		
		logger = Logger.getLogger(InvalidCoordinateValueException.class.getName());
		
		this.logMsg = msg;
	}
}
