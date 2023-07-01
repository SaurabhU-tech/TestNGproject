package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssertion {
	@Test
	public void Assertion() {
		//test data
		String str1 = new String ("abc");
		String str2 = new String ("abc");
		String str3 = null;
		String str4 = "abc";
		String str5 = "abc";
		
		int val1 = 5;
		int val2 = 6;
		
		String[] expectedArray = {"one", "two", "three"};
		String[] actualArray = {"one", "two", "three"};
		
		//Check that two objects are equal
		Assert.assertEquals(str1, str2);
		
		//Check that a condition is true
		Assert.assertTrue (val1 < val2);
		
		//Check that a condition is false
		Assert.assertFalse (val1 > val2);
		
		//Check that an object isn't null
		Assert.assertNotNull(str1);
		
		//Check that an object is null
		Assert.assertNull(str3);
		
		//Check if two object references point to the same object
		Assert.assertSame(str4, str5);
		
		//Check if two object references not point to the same object
		Assert.assertNotSame(str1, str3);
		
		//Check whether two arrays are equal to each other.
		Assert.assertEquals(expectedArray, actualArray, "both arrays are not same...");
	}
}