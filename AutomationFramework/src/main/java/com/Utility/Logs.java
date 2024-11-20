package com.Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.BaseClass.BaseClass;

public class Logs extends BaseClass {
	public static Logger Log = LogManager.getLogger(Logs.class);
	
		public static void startTestCase(String sTestCaseName){		  
			 Log.info("====================================="+sTestCaseName+" TEST START=========================================");
			 }
		
		public static void endTestCase(String sTestCaseName){
			Log.info("====================================="+sTestCaseName+" TEST END=========================================");
			 }
		
		 public static void info(String message) {
				Log.info(message);
				}

		 public static void warn(String message) {
		    Log.warn(message);
			}

		 public static void error(String message) {
			 Log.error(message);
			}

		 public static void fatal(String message) {
		    Log.fatal(message);
			}

		 public static void debug(String message) {
		    Log.debug(message);
			}
}
