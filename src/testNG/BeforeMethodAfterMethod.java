package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodAfterMethod {

	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Desktop\\SelJar\\chromedriver.exe");
		driver = new ChromeDriver();
	}
		
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
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
	public void verifyRediffTitle() {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Rediffmail");
	}

}
