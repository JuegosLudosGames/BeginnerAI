package me.trio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to manage Logging of Debug Items
 * 
 * @author Kyle
 *
 */
public class DebugLogging {

	String path;
	File f;
	FileWriter writer;

	/**
	 * 
	 * @param path
	 *            the filepath for the Debug file
	 */
	public DebugLogging(String path) {
		this.path = path;
		f = new File(path + "\\log.txt");

		createSchema();

	}
	
	/**
	 * Logs a message in the log file
	 * @param p the message to log
	 */
	public void log(String p) {
		try {
			writer.write("[Debug] " + p);
		} catch (Exception e) {

		}

	}

	// creates file schemas if file doesnt exist
	private void createSchema() {

		try {

			// tell user that we are creating a file
			System.out.println("Creating File");

			// does the file exist
			if (!f.exists()) {
				// creates file if it doesnt exist
				f.createNewFile();
			} else {
				// renames the old file if exists
				f.renameTo(new File(path + "\\oldlog.txt"));
				// creates the new file
				f.createNewFile();
			}

			// tell user
			System.out.println("Created File");

			// start writer object
			writer = new FileWriter(f);

		} catch (Exception e) {
			// if no work, tell user it no work
			System.out.println("Yea it doesnt work");
			// stop program and print
			e.printStackTrace();
		}
	}
	
	/**
	 * Closes the Logger
	 */
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
		}
	}
}
