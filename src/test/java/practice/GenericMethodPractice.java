package practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericMethodPractice {
	
	public static void main(String[] args) throws IOException { //Caller function //user
		
		PropertyFileUtility p = new PropertyFileUtility();
		String value = p.readDataFromPropertyFile("username");
		System.out.println(value);
		
		ExcelFileUtility e = new ExcelFileUtility();
		String val = e.readDataFromExcel("Contacts", 1, 1);
		System.out.println(val);
		
		JavaUtility j = new JavaUtility();
		String date = j.getSystemDate();
		System.out.println(date);
		
		
		
		
		
		
//		int a = 10;
//		int b = 20;
//		int c = a+b;
//		System.out.println(c);
		
//		int sum = add(10, 20);
//		System.out.println(sum+10);
//		add(2, 450);
//		add(300, 40);
		
	}
	
	public static int add(int a, int b) // Called function Generic method reusable method
	{
		int c = a+b;
		return c;
	}

}
