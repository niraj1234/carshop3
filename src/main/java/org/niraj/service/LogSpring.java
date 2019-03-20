package org.niraj.service;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LogSpring {

	public static LogSpring logSpr;
    DailyRollingFileAppender drfa;

    public LogSpring() {
		System.out.println("Default Constructor LogSpring called");
	}

	public LogSpring(String layoutVal , String logFilePath) {
		try {
			PatternLayout layout = new PatternLayout(layoutVal);

			String log_file_path = logFilePath;
			drfa = new DailyRollingFileAppender(layout, log_file_path, "'.'yyyy-MM-dd");
			LogManager.getRootLogger().addAppender(drfa);

			System.out.println("LogSpring Constructor called ==> LOgFile Path ==>" + logFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	
	public void log(String className, String message)
    {
    	Logger logger = Logger.getLogger(className);
    	logger.setLevel(Level.ALL);
    	logger.debug(message);
    }
    
    
	public void error(String className, Object message)
    {
    	Logger logger = Logger.getLogger(className);
    	logger.setLevel(Level.ERROR);
    	logger.error(message);
    }
	
}
