package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiTestCases {
//		Note: TestNG Test cases are executed in alphabetical order:
//		Execution Flow:
//		iii) closeBrowser()    : Failed: Because browser is not yet opened
//		i) launchBrowser()   : Passed
//		ii) verifyTitle()           : Passed

		WebDriver driver;
		
		@Test
		public void launchBrowser() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Desktop\\SelJar\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		@Test
		public void verifyTitle() {
			driver.get("https://www.google.co.in/");
			String pageTitle = driver.getTitle();
			Assert.assertEquals(pageTitle, "Google");
		}
		
		@Test
		public void closeBrowser() {
			driver.close();
		}

}
