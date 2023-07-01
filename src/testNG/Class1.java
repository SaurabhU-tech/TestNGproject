package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class1 {

	@BeforeMethod
	public void login() {
		System.out.println("Admin login Successfully");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Admin Logout Successfully");
	}
	
	@Test(priority = 1)
	public void addVendor() {
		System.out.println("Vendor Added Successfully");
	}
	
	@Test(priority = 2)
	public void addProduct() {
		System.out.println("Product Added Successfully");
	}
	
	@Test(priority = 3)
	public void addCurrency() {
		System.out.println("Currency Added Successfully");
	}

}
