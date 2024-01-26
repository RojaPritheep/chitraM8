package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU {

	public static void main(String[] args) throws InterruptedException, IOException {

		//Create Object Utilities
		PropertyFileUtility p = new PropertyFileUtility();
		ExcelFileUtility e = new ExcelFileUtility();
		SeleniumUtility s = new SeleniumUtility();
		
		// Read all the required Data
		/* Read common data from Property file */
		String URL = p.readDataFromPropertyFile("url");
		String USERNAME = p.readDataFromPropertyFile("username");
		String PASSWORD = p.readDataFromPropertyFile("password");

		/* Read Test data from Excel File */
		String LASTNAME = e.readDataFromExcel("Contacts", 1, 2);

		// Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		s.maximizeWindow(driver);
		s.addimplicitlyWait(driver);

		// Step 2: Load the URL
		driver.get(URL);

		// Step 3: Login to Application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		
		
		
		

		// Step 4: Navigate to Contacts Link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 5: Click on Create contact Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 6: Create contact With Mandatory details
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 8 Validate
		String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (conHeader.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println(conHeader);
		} else {
			System.out.println("FAIL");
		}

		// Step 9: Logout of App
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		s.mouseOverAction(driver, ele);

		Thread.sleep(1000);

		driver.findElement(By.linkText("Sign Out")).click();

		// Step 10: Close the browser
		driver.quit();
	}

}
