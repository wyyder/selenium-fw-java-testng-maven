package com.wyyder.library;

public class SystemUtility {

	public static String getRootDirectory() {
		return System.getProperty("user.dir");
	}

	public static String getOperatingSystem() {
		return System.getProperty("os.name");
	}
}
