package opencart.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.AddressBookPage;
import opencart.pageobjects.LoginPage;
import opencart.pageobjects.MyAccountPage;

public class AddressBookTest extends BaseTest {
	WebDriver driver;
	String expectedMsg = "Your address has been successfully added";

	@Test(dataProvider = "getData")
	public void addAddress(HashMap<String, String> input) throws InterruptedException {
		LoginPage loginPage = landingPage.getToLoginPage();
		MyAccountPage myAccountPage = loginPage.loginToApp(input.get("email"), input.get("password"));
		Thread.sleep(3000);
		AddressBookPage addressBookPage = myAccountPage.getAddressBook();
		addressBookPage.addNewAddress(input.get("firstName"), input.get("lastName"), input.get("company"),
				input.get("address1"), input.get("city"), input.get("postalCode"), input.get("countryName"),
				input.get("regionName"));
		String actualMsg = addressBookPage.getSuccessMsgOfAdded();
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//opencart//data//address.json");

		return new Object[][] { { data.get(0) } };
	}

}
