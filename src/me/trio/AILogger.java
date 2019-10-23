package me.trio;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	
	private File dataFile;
	private FileWriter writer;

	@Override
	public void start() {

		log = this;
		
		String dataFolder = System.getenv("LOCALAPPDATA");
		
		//logFile = new DebugLogging(dataFolder + "\\AIStuff");
		createFileSchema(dataFolder);
		
	}
	
	private void createFileSchema(String location) {
		//gets the datapath of the future file
		
		//gets date
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		//gets base location with date
		String nlocation = location + "\\AIStuff\\ " + date + "data.csv";
		
		//creates file instance
		File f = new File(location);
		//repetition number
		int x = 0;
		//keeps regenerating until non-existant file found
		while(f.exists()) {
			//ups repetition number 
			x++;
			//regenerates the file location
			nlocation = location + "\\AIStuff\\ " + date + "data(" + x + ").csv";
			//creates new file instance
			f = new File(nlocation);
		}
		
		dataFile = f;
		
		try {
			
			//creates the file
			dataFile.createNewFile();
			
			//creates new writer
			writer = new FileWriter(dataFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//writes header
		writeRow(new String[] {"Generation","Lowest","Median","Highest","Average"});
	}
	
	public void writeLine(String m) {
		try {
			writer.write(m + "\n");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//TODO please fix later
	public void writeRow(String[] m) {
		try {
			for(int x = 0; x < m.length; x++) {
				if(x != 0)
					writer.write(",");
				writer.write(m[x]);
			}
			writer.write("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(int generation, float lowest, float median, float highest, float average) {
		writeRow(new String[] {String.valueOf(generation), String.valueOf(lowest), String.valueOf(median), String.valueOf(highest), String.valueOf(average)});
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
		//logFile.close();
	}
	
	/**
	 * Logs a message 
	 * @param m the message to log
	 */
	public void log(String m) {
		System.out.println(m);
		//logFile.log(m);
	}
	
	/**
	 * Logs a message as a warning
	 * @param m the message to log
	 */
	public void warn(String m) {
		System.out.print("[WARNING] " + m);
		//logFile.log("[WARNING] " + m);
	}
	
	/**
	 * Logs a message as a Error
	 * @param m the message to log
	 */
	public void err(String m) {
		System.err.println(m);
		//logFile.log("[ERROR] " + m);
	}

	@Override
	public void onRender(Graphics graphic) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
