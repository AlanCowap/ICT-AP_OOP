//Demo Java Logging API, and System.err.println()


package com.alancowap.ictap.demo;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogApp {

	private static final Logger LOG= Logger.getLogger( LogApp.class.getName() );
	
	public static void main(String[] args) {
		System.out.println("LogApp Started");
		
		Handler consoleHandler = new ConsoleHandler();
		Handler fileHandler = null;
		
		try{
			fileHandler  = new FileHandler("./test.log");
		}catch(IOException ioe){
			//LOG.log(Level.SEVERE, "Error opening file.", ioe);
			System.err.println("Error opening file");
		}
		
		//Add Handlers
		LOG.addHandler(consoleHandler);
		LOG.addHandler(fileHandler);
		
		consoleHandler.setLevel(Level.ALL);
		fileHandler.setLevel(Level.ALL);
		LOG.setLevel(Level.ALL);

		LOG.log( Level.FINE, "Logging - in the main", 1 );

		LOG.exiting(Level.FINE.toString(), "Logging - in the main");
		
		LOG.removeHandler(consoleHandler);
		LOG.removeHandler(fileHandler);
		consoleHandler.close();
		fileHandler.close();

		try{
			int oops = 10/0;
		}catch(ArithmeticException aex){
			System.err.println("An Arithmetic Exception ocurred\n");
			aex.printStackTrace();
		}
		
	}

}
