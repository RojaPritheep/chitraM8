package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;


public class CreateNewContactPage extends SeleniumUtility{
	
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	

	// initiliazation
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

    //Business Logic
	
	/**
	 * This method will create new contact with mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create new contact with Lead source drop down
	 * @param LASTNAME
	 * @param LEADSOURCEValue
	 */
	public void createNewContact(String LASTNAME, String LEADSOURCEValue)
	{
		LastNameEdt.sendKeys(LASTNAME);
		handleDropdown(leadSourceDropDown, LEADSOURCEValue);
		SaveBtn.click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
