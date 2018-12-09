/**
 * UnknownCoordinateException
 * 
 * 1.0
 * 
 * 08.12.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.exceptions;

import java.util.logging.Logger;

public class UnknownCoordinateTypeException extends CoordinateException{
	
	public UnknownCoordinateTypeException() {
		super();
		
		this.logger = Logger.getLogger(UnknownCoordinateTypeException.class.getName());
	}
	
	public UnknownCoordinateTypeException(String msg) {
		super(msg);
		
		this.logger = Logger.getLogger(UnknownCoordinateTypeException.class.getName());
	}
}
