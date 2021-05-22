import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	static String root_directory = System.getProperty("user.dir");

	public static void main(String[] args) {

		String baseUrl = "https://opensource-demo.orangehrmlive.com/";
		String expectedTitle = "OrangeHRM";
		String actualTitle = "";

		System.out.println(root_directory);

		System.setProperty("webdriver.gecko.driver",
				root_directory + File.separator + "driver" + File.separator + "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

//		// comment the above 2 lines and uncomment below 2 lines to use Chrome
//		// System.setProperty("webdriver.chrome.driver","C:\Users\Wyyder\Documents\gitLearning\selenium-fw-java-testng-maven\driver\chromedriver.exee");
//		// WebDriver driver = new ChromeDriver();
//
		driver.get(baseUrl);
		actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		driver.close();

	}
}
