package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void sample()
	{
		String data = "abc";
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals(0, 1);
		
		Assert.assertTrue(data.contains("y"));
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		
		
		
	}
	
	@Test
	public void sampleSoft()
	{
		SoftAssert sa = new SoftAssert();
		
		String data = "abc";
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		sa.assertEquals(0, 1); //failed
		
		System.out.println("Step 3");
		
		sa.assertTrue(data.contains("y")); //failed
		
		System.out.println("Step 4");
		
		sa.assertAll();
		
		
		
	}

}
