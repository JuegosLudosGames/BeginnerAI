package me.trio;

import java.io.File;

import org.newdawn.slick.Graphics;

public class Logger implements GameObject {
	
	private static Logger log;
	
	public static Logger getLogger() {
		return log;
	}
	
	private File logFile;
	private File dataFile;

	@Override
	public void start() {
		// TODO Auto-generated method stub
		String dataFolder = System.getenv("LOCALAPPDATA");
		
		
		
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
		// TODO Auto-generated method stub
		
	}
	
	public void log() {
		
	}

	@Override
	public void onRender(Graphics graphic) {
		// TODO Auto-generated method stub
		
	}
	
}
