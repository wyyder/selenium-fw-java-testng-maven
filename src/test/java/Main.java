import com.wyyder.library.Browser;

public class Main {

	public static void main(String[] args) {

		/* Variable initialization */
		String baseUrl = "https://opensource-demo.orangehrmlive.com/";
		String expectedTitle = "OrangeHRM";

		Browser browser = new Browser();
		browser.launchURL(baseUrl);
		String actualTitle = browser.getTitle();
		browser.closeBrowser();

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

	}
}
