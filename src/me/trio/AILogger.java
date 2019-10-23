package me.trio;

import java.io.File;

import org.newdawn.slick.Graphics;

public class AILogger implements GameObject {
	
	private static AILogger log;
	
	/**
	 * Gets the current logger
	 * @return returns the current logger
	 */
	public static AILogger getLogger() {
		return log;
	}
	
	private DebugLogging logFile;
	private File dataFile;

	@Override
	public void start() {

		log = this;
		
		String dataFolder = System.getenv("LOCALAPPDATA");
		
		logFile = new DebugLogging(dataFolder + "\\AIStuff");
		
	}

	@Override
	public void earlyUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lateUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnable(boolean enable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		logFile.close();
	}
	
	/**
	 * Logs a message 
	 * @param m the message to log
	 */
	public void log(String m) {
		System.out.println(m);
		logFile.log(m);
	}
	
	/**
	 * Logs a message as a warning
	 * @param m the message to log
	 */
	public void warn(String m) {
		System.out.print("[WARNING] " + m);
		logFile.log("[WARNING] " + m);
	}
	
	/**
	 * Logs a message as a Error
	 * @param m the message to log
	 */
	public void err(String m) {
		System.err.println(m);
		logFile.log("[ERROR] " + m);
	}

	@Override
	public void onRender(Graphics graphic) {
		// TODO Auto-generated method stub
		
	}
	
}
