/**
 * PhotoFactoryException
 * 
 * 1.0
 * 
 * 08.12.2018
 * 
 * Copyright (c) by Patrick Lodes
 */

package org.wahlzeit.exceptions;

import java.util.logging.Logger;

public class PhotoFactoryException extends Exception{
	
	protected Logger logger = Logger.getLogger(PhotoFactoryException.class.getName());
	
	String logMsg;
	
	public PhotoFactoryException() {
		
	}
	
	public PhotoFactoryException(String msg) {
		super(msg);
		logMsg = msg;
	}
	
	public void logException() {
		logger.warning(logMsg);
	}
}
