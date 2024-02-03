package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"regression", "master"})
	public void verify_account_registration() 
	{
		logger.info("********** Starting TC_001_AccountRegistrationTest **********");
		
		logger.debug("Application Logs started.....");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		logger.info("Entering Customer Details.... ");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");		// randomly generated the gmailID
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Clicked on Continue");
		
		String confmsg = regpage.getConfirmationMsg();
		
		logger.info("Validating expected message.....");
		
		if(confmsg.equals("Your Account Has Been Created!")) // !
		{
			logger.info("Test Passed...");
			Assert.assertTrue(true );
		}
		else 
		{
			logger.error("Test Failed...");
			Assert.fail();
		}
		
		}
		catch(Exception e) 
		{
			logger.error("Test Failed....");
			Assert.fail();
		}
		
		logger.debug("Application Logs ended.....");
		logger.info("********** Finished TC_001_AccountRegistrationTest **********");
		
	}
	
}
