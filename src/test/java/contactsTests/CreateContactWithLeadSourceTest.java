package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
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

public class CreateContactWithLeadSourceTest extends BaseClass{

	@Test(groups = "RegressionSuite")
	public void createContactWithLead() throws IOException, InterruptedException
	{

		/* Read Test data from Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 4, 3);

		// Step 4: Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// Step 5: Click on Create contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step 6: Create contact With Mandatory details
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE);

		// Step 8 Validate
		ContactInfoPage cip = new ContactInfoPage(driver); //Fail
		String conHeader = cip.captureHeaderText();
		Assert.assertTrue(conHeader.contains(LASTNAME));
		System.out.println(conHeader);
		
		
	}

}
