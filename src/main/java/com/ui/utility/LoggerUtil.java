package com.ui.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
 
	
	private LoggerUtil() {}
	
	public  static Logger getlogger (Class<?> clasz) {
		Logger logger=null;
		if(logger==null)
		{
		logger=LogManager.getLogger(clasz)	;
			
		}
		return logger;
		}
	
	
}
