package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_LoginDDT(String email, String password, String exp) {
		logger.info("*********** Starting TC_003_LoginDDT ***********");

		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount link....");
			hp.clickLogin(); // Login link under MyAccount from HomePage
			logger.info("clicked on Login link under MyAccount ...");

			// Login Page
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password....");
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin(); // Login Button in Login Page
			logger.info("clicked on Login button ...");

			// MyAccount Page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();

			// Positive Testing
			if (exp.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			// Negative Testing
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("********** Finished TC_003_LoginDDT **********");

	}
}
