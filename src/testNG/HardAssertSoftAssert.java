package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertSoftAssert {

	SoftAssert obj = new SoftAssert();
	
	@Test
	public void verifyTitle() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Desktop\\SelJar\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open Browser");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		System.out.println("Launch Browser");
		//Hard Assert: This will terminate the program once hard assert fail
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Google");
		driver.findElement(By.id("login1")).sendKeys("India1234");
		System.out.println("Enter User Name");
		//Soft Assert: This will not terminate the program even if assert fail
		obj.assertEquals(pageTitle, "Google");
		driver.findElement(By.id("password")).sendKeys("XYZ@123456");
		System.out.println("Enter Password");
		obj.assertEquals(pageTitle, "Google");
		System.out.println("Verify Title");
		obj.assertAll();
	}

}
