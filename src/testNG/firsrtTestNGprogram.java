package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firsrtTestNGprogram {

	@Test
    public void verifyTitle() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Desktop\\SelJar\\chromedriver.exe");	
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    String pageTitle = driver.getTitle();
    Assert.assertEquals(pageTitle, "Google");   //Assert.assertEquals(actual,expected);  
    driver.close(); 
    }

	

}
