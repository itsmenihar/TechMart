package opencart.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.LoginPage;
import opencart.pageobjects.MyAccountPage;
import opencart.pageobjects.ProductCataloguePage;

public class SearchFunctionalityTest extends BaseTest {
	WebDriver driver;
	String email = "bikashsahu@gmail.com";
	String password = "bikashsahu#123";

	@Test
	public void TC_SF_001() {
		String ExpectedproductName = "iMac";
		ProductCataloguePage productCataloguePage = landingPage.getSearchPlaceholder(ExpectedproductName);
		String[] actualProduct = productCataloguePage.getProductName();
		Assert.assertEquals(actualProduct, ExpectedproductName);
	}

	@Test
	public void TC_SF_002() {
		String searchProductName = "Fitbit";
		String ExpectedMessage = "There is no product that matches the search criteria.";
		ProductCataloguePage productCataloguePage = landingPage.getSearchPlaceholder(searchProductName);
		String actualMessage = productCataloguePage.getMessage();
		Assert.assertEquals(actualMessage, ExpectedMessage);

	}

	@Test
	public void TC_SF_003() {
		String ExpectedMessage = "There is no product that matches the search criteria.";
		ProductCataloguePage productCataloguePage = landingPage.getSearchPlaceholder("");
		String actualMessage = productCataloguePage.getMessage();
		Assert.assertEquals(actualMessage, ExpectedMessage);

	}

	@Test
	public void TC_SF_004() throws InterruptedException {
		String productName = "iMac";
		LoginPage loginPage = landingPage.getToLoginPage();
		MyAccountPage myAccountPage = loginPage.loginToApp(email, password);
		Thread.sleep(2000);
		ProductCataloguePage productCataloguePage = myAccountPage.getSearchPlaceholder(productName);
		String[] actualProduct = productCataloguePage.getProductName();
		for (int i = 0; i < actualProduct.length; i++) {
			String name = actualProduct[i];
			Assert.assertTrue(name.contains(productName));
		}
	}

	@Test
	public void TC_SF_005() {
		String productName = "Mac";
		ProductCataloguePage productCataloguePage = landingPage.getSearchPlaceholder(productName);
		String[] actualProduct = productCataloguePage.getProductName();
		for (int i = 0; i < actualProduct.length; i++) {
			String name = actualProduct[i];
			Assert.assertTrue(name.contains(productName));
		}

	}

}
