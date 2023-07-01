package testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoveDataFromExcelToWeb {

	public static void main(String[] args) throws IOException, InterruptedException {
		// WAP to move data from Excel App to Web App
		FileInputStream file = new FileInputStream("C:\\Users\\asus\\Desktop\\LoginData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(1).getLastCellNum();
		
		System.out.println(rows);
		System.out.println(columns);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\Desktop\\SelJar\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		//Launch Rediff mail Signin page
		dr.get("https://mail.rediff.com/cgi-bin/login.cgi"); 
		for (int r = 1; r <= rows; r++) {
			int c = 0;
			dr.findElement(By.id("login1")).clear();
			Thread.sleep(3000);
			dr.findElement(By.id("login1")).sendKeys(sheet.getRow(r).getCell(c).getStringCellValue());
			c++;
			dr.findElement(By.id("password")).clear();
			Thread.sleep(3000);
			dr.findElement(By.id("password")).sendKeys(sheet.getRow(r).getCell(c).getStringCellValue());
			Thread.sleep(3000);
			dr.findElement(By.name("proceed")).click();
		}
		wb.close();
	}

}
