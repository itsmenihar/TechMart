package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.AccountLogoutPage;
import opencart.pageobjects.LoginPage;
import opencart.pageobjects.MyAccountPage;

public class LogoutTest extends BaseTest {
	WebDriver driver;
	String email = "bikashsahu@gmail.com";
	String password = "bikashsahu#123";

	@Test
	public void logOutFromRightSideBar() throws InterruptedException {
		LoginPage loginPage = landingPage.getToLoginPage();
		MyAccountPage myAccountPage = loginPage.loginToApp(email, password);
		AccountLogoutPage accountLogoutPage = myAccountPage.getLogOut();
		Assert.assertEquals(accountLogoutPage.getText(), "Account Logout");
		accountLogoutPage.getContinueButton();
	}
}
