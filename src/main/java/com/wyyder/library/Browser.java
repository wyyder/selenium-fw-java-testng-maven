package com.wyyder.library;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	private WebDriver driver;
	private String browserType;

	public Browser() {
		browserType = "Firefox";
		initializeDriver();
	}

	/* Getters */
	public String getBrowserType() {
		return browserType;
	}

	/* Reusable methods */
	public String getDriverPath() {
		return SystemUtility.getRootDirectory() + File.separator + "driver";
	}

	public String getDriverName() {
		/* Dynamic driver selection */
		String driverName = "geckodriver";

		if ("chrome".equalsIgnoreCase(browserType)) {
			driverName = "chromedriver";
		}

		if (!"linux".equalsIgnoreCase(SystemUtility.getOperatingSystem())) {
			driverName = driverName + ".exe";
		}
		return driverName;
	}

	/* Browser initialization */
	public void initializeDriver() {
		if ("chrome".equalsIgnoreCase(browserType)) {
			initializeChromeDriver();
		} else {
			initializeFirefoxDriver();
		}
	}

	public void initializeFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", getDriverPath() + File.separator + getDriverName());
		driver = new FirefoxDriver();
	}

	public void initializeChromeDriver() {
		System.setProperty("webdriver.chrome.driver", getDriverPath() + File.separator + getDriverName());
		driver = new ChromeDriver();
	}

	/* Browser actions */
	public void launchURL(String url) {
		driver.get(url);
	}

	public void closeBrowser() {
		driver.close();
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
