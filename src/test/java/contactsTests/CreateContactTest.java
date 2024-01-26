package contactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createContactWithMandatoryInfo() throws IOException, InterruptedException
	{
		/* Read Test data from Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		// Step 4: Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// Step 5: Click on Create contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		// Step 6: Create contact With Mandatory details
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);

		// Step 8 Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String conHeader = cip.captureHeaderText();
		Assert.assertTrue(conHeader.contains(LASTNAME));
		System.out.println(conHeader);
		
		
	}

	@Test
	public void demoTest()
	{
		Assert.fail();
		System.out.println("Hi");
	}
}
