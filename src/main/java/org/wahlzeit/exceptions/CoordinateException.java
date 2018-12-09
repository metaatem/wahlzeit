package org.wahlzeit.exceptions;

import java.util.logging.Logger;

public class CoordinateException extends Exception{
	
	protected Logger logger;
	
	protected String logMsg;
	
	public CoordinateException() {
		super();
		
		logger = Logger.getLogger(CoordinateException.class.getName());
	}
	
	public CoordinateException(String msg) {
		super(msg);
		
		logger = Logger.getLogger(CoordinateException.class.getName());
		
		this.logMsg = msg;
	}
	
	public void logException() {
		logger.warning(logMsg);
	}
}
