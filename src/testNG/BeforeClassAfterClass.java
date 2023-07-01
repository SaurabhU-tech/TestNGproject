package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeClassAfterClass {

	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Desktop\\SelJar\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test(priority = 1)
	public void verifyGoogleTitle() throws InterruptedException {
		driver.get("https://www.google.co.in/");
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Google");
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void verifyRediffTitle() throws InterruptedException {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		String pageTitle1 = driver.getTitle();
		Assert.assertEquals(pageTitle1, "Rediffmail");
		Thread.sleep(3000);
	}
}
