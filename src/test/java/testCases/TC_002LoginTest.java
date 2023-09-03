package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002LoginTest extends BaseClass {
	@Test(groups = { "sanity", "master" })
	public void test_Login() {
		logger.info("starting TC_002LoginTest");
		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			// Loginpage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPassword(rb.getString("password"));
			lp.clickLogin();
			// MyAccountPage
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();
			Assert.assertEquals(targetpage, true);
			logger.info("finishing TC_002LoginTest");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("finishing TC_002LoginTest");
	}
}
