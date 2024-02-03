package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.*;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{	
	@Test(groups= {"sanity", "master"})
	public void verify_login() 
	{
		logger.info("********** Starting TC_002_LoginTest **********");
		logger.debug("Capturing application debug logs....");
		
		try 
		{
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount link....");
			hp.clickLogin(); // Login link under MyAccount from HomePage
			logger.info("clicked on Login link under MyAccount ...");
			
			// Login Page
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password....");
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin(); // Login Button in Login Page
			logger.info("clicked on Login button ...");
			
			// MyAccount Page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();
			
				if(targetpage == true) 
				{
					logger.info("Login Test Passed");
					Assert.assertTrue(true);
				}
				else 
				{
					logger.error("Login Test Failed");
					Assert.fail();
				}
			}
		
		catch(Exception ex) 
		{
			Assert.fail();
		}
		
		logger.info("********** Finished TC_002_LoginTest **********");
		
	}

}
