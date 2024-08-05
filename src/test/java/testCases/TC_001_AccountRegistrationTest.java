package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.AccountRegistrationPage;
import pageObjectClasses.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master", "DataDriven"}) //Step8 groups added
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		
		try {
			// Test part
			// From HomePage class(Page Object class) - Creating Objects to invoke the methods
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link.. ");
			
			hp.clickRegister();
			logger.info("Clicked on Register Link.. ");
			
			// From Account Registration Page class(Page Object class) - Creating Objects to invoke the methods
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
			logger.info("Providing customer details...");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
			regpage.setTelephone(randomeNumber());
			
			String password=randomAlphaNumeric();
			
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			// Validation part
			logger.info("Validating expected message..");
			String confmsg=regpage.getConfirmationMsg(); // converting to string
				if(confmsg.equals("Your Account Has Been Created!")) {
					Assert.assertTrue(true);
				} else {
					logger.error("Test failed");
					logger.debug("Debug logs");
					Assert.assertTrue(false);
				}
			
		} catch (Exception e) {
			//logger.error("Test failed: " + e.getMessage());
			//logger.debug("debug log: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally {
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
		
	}
}








