package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	// elements

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement inkRegister;

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement linkMyaccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement lnkLogin;

//action methods
	public void clickMyAccount() {
		linkMyaccount.click();
	}

	public void clickRegister() {
		inkRegister.click();
	}

	public void clickLogin() {
		lnkLogin.click();
	}

}
