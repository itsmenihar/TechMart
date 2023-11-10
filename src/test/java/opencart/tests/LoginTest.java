package opencart.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.LoginPage;
import opencart.pageobjects.MyAccountPage;

public class LoginTest extends BaseTest {
	WebDriver driver;

	String titleOfPage = "My Account";
	String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";

//Login to application with valid data like valid email and valid password	
	@Test(dataProvider = "getData")
	public void loginWithvalidData(HashMap<String, String> input) {
		LoginPage loginPage = landingPage.getToLoginPage();
		MyAccountPage myAccountPage = loginPage.loginToApp(input.get("email"), input.get("password"));
		String title = myAccountPage.getMyAccountTitle();
		Assert.assertEquals(title, titleOfPage);
	}

//Login to application without email and password
	@Test
	public void loginWithoutEmailAndPassword() {
		LoginPage loginPage = landingPage.getToLoginPage();
		loginPage.loginToApp("", "");
		String actualWarning = loginPage.getErrorWarningForLogin();
		Assert.assertEquals(actualWarning, expectedWarning);
	}

//Login to application with valid email and invalid password
	@Test
	public void loginWithValidEmailInvalidPassword() {
		LoginPage loginPage = landingPage.getToLoginPage();
		loginPage.loginToApp("alokbehera@gmail.com", "a#356");
		String actualWarning = loginPage.getErrorWarningForLogin();
		Assert.assertEquals(actualWarning, expectedWarning);
	}

// Login to application with invalid email and valid password
	@Test
	public void loginWithInvalidEmailvalidPassword() {
		LoginPage loginPage = landingPage.getToLoginPage();
		loginPage.loginToApp("admingmail.com", "bikashsahu#123");
		String actualWarning = loginPage.getErrorWarningForLogin();
		Assert.assertEquals(actualWarning, expectedWarning);
	}

	// Login to application with valid email and valid password but which is not
	// registered
	@Test
	public void loginWithUnregisteredEmailPassword() {
		LoginPage loginPage = landingPage.getToLoginPage();
		loginPage.loginToApp("bibeknaik@gmail.com", "bibeknaik#123");
		String actualWarning = loginPage.getErrorWarningForLogin();
		Assert.assertEquals(actualWarning, expectedWarning);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//opencart//data//Registration.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
