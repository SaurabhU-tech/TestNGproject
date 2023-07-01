package testNG;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNG {

	WebDriver driver;
	@BeforeMethod
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Desktop\\SelJar\\chromedriver.exe"); 
		//Create the browser driver (It launches the browser with blank URL)
		driver = new ChromeDriver();
		//Navigate to specific URL
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}
	
	@DataProvider
	public Object [][] getLoginData() throws Exception
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\asus\\Desktop\\LoginData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet =  workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(1).getLastCellNum();
		
		System.out.println(rows);
		System.out.println(columns);
		Object arr[][] = new Object[rows+1][columns];
		
		for(int r = 0; r<=rows; r++) 
		{
			XSSFRow row = sheet.getRow(r);
			
			for(int c = 0; c<columns; c++) 
			{
				XSSFCell cell = row.getCell(c);
				
				arr[r][c] = cell.getStringCellValue();
				System.out.print(arr[r][c]+"  ");
				
				
			}
			System.out.println();
		}
		return arr;
	}
	
	@Test(dataProvider = "getLoginData")
	public void loginTest(String Username, String Password)
	{
		driver.findElement(By.id("login1")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.name("proceed")).click();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
