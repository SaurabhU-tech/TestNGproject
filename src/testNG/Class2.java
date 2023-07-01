package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class2 {

	@BeforeMethod
	public void login() {
		System.out.println("Admin login Successfully");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Admin Logout Successfully");
	}
	
	@Test(priority = 4)
	public void deleteVendor() {
		System.out.println("Vendor Deleted Successfully");
	}
	
	@Test(priority = 5)
	public void deleteProduct() {
		System.out.println("Product Deleted Successfully");
	}
	
	@Test(priority = 6)
	public void deleteCurrency() {
		System.out.println("Currency Deleted Successfully");
	}

}
