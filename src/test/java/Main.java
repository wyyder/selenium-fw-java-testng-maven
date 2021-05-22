import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	static String root_directory;
	static WebDriver driver;
	static String driverName;

	public static void main(String[] args) {

		/* Variable initialization */
		String baseUrl = "https://opensource-demo.orangehrmlive.com/";
		String expectedTitle = "OrangeHRM";
		String actualTitle = "";

		root_directory = System.getProperty("user.dir");
		driverName = "geckodriver";

		/* Dynamic drive selection */
		if (!"linux".equalsIgnoreCase(System.getProperty("os.name"))) {
			driverName = driverName + ".exe";
		}

		initializeFirefoxDriver();
		driver.get(baseUrl);
		actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		driver.close();

	}

	public static void initializeFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver",
				root_directory + File.separator + "driver" + File.separator + driverName);
		driver = new FirefoxDriver();
	}

	public static void initializeChromeDriver() {
		System.setProperty("webdriver.chrome.driver",
				root_directory + File.separator + "driver" + File.separator + driverName);
		driver = new ChromeDriver();
	}
}
