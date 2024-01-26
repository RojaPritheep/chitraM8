package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createCustomer()
	{
		Assert.fail();
		System.out.println("create"); //failed pass
	}
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		
		System.out.println("modify"); //skip run
	}
	
	@Test
	public void deleteCustomer()
	{
		
		System.out.println("delete");
	}

}
