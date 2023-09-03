package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountregistrationTest extends BaseClass {

	@Test(groups = { "regression", "master" })
	public void test_AccountRegistration() {
		logger.info("*********TC_001_AccountregistrationTest started**************");
		HomePage hp = new HomePage(driver);
		logger.info("clicking on My Account link.....");
		hp.clickMyAccount();
		logger.info("clicking on my Register link");
		hp.clickRegister();
		logger.info("customer details providing");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString() + "@gmail.com");
		regpage.setTelephone(randomeNumber());
		String password = randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		String confrMsg = regpage.getConfirmationMsg();
		if (confrMsg.equals("Your Account Has Been Created!")) {
			logger.info("Registration successfull");
			Assert.assertTrue(true);
		} else {
			logger.error("Registration failed");
			Assert.fail();
		}
		logger.info("***TC_001_AccountregistrationTes finished");
	}

}