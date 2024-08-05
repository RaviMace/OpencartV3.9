package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.HomePage;
import pageObjectClasses.LoginPage;
import pageObjectClasses.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{

	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void verify_login()
	{
		logger.info("**** Starting TC_002_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		try
		{
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		System.out.println("Clicked Account");
		logger.info("clicked on myaccount link on the home page..");
		hp.clickLogin(); //Login link under MyAccount
		System.out.println("Clicked Login page");
		logger.info("clicked on login link under myaccount..");
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin(); //Login button
		logger.info("clicked on login button..");
		System.out.println("Succesfully login");
		
		//My Account Page
		MyAccountPage macc=new MyAccountPage(driver);
				
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);  //Assert.assertEquals(targetPage, true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");
	}
}
