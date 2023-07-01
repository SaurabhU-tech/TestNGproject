package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class priorityTestCases {
	WebDriver driver;

	@Test(priority=1)
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Desktop\\SelJar\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority=2)
	public void verifyTitle() {
		driver.get("https://www.google.co.in/");
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Google");
	}
	
	@Test(priority=3)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		Reporter.log("Driver Closed After Testing");
	}

}
