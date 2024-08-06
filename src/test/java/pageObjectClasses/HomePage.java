package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// The is the actual page object class, which is home page
public class HomePage extends BasePage{

	// Invoking the driver from BasePage class constructor
	public HomePage(WebDriver driver)
	{
		super(driver); // Invoking and initiating 
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement lnkRegister;
	
	@FindBy(linkText = "Login")   // Login link added in step5
	WebElement linkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;

	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;
	
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()    // added in step5
	{
		linkLogin.click();
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}

	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}


}
