package io.github.ocnscrim.scrimmage.utils;

import io.github.ocnscrim.scrimmage.Scrimmage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

	private static Logger log;

	static {
		Log.log = Scrimmage.get().getLogger();
	}

	public static void log(Level lvl, String msg) {
		log.log(lvl, msg);
	}

	public static void log(String msg) {
		log(Level.INFO, msg);
	}

	public static void log(Exception e) {
		log(Level.WARNING, e.getMessage());
		e.printStackTrace();
	}

}
