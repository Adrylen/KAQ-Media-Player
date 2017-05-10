package project.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class console {
	private static Logger logger = Logger.getLogger(console.class.getName());

	private console(){}

	public static void log() {
		log("");
	}

	public static void log(String message) {
		logger.log(Level.INFO, message);
	}

	public static void log(String message, Exception e) {
		logger.log(Level.WARNING, message, e);
	}
}
