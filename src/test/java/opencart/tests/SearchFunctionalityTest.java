package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.LoginPage;
import opencart.pageobjects.MyAccountPage;
import opencart.pageobjects.SearchPage;

public class SearchFunctionalityTest extends BaseTest {
	WebDriver driver;
	String email = "bikashsahu@gmail.com";
	String password = "bikashsahu#123";

	@Test
	public void TC_SF_001() {
		String ExpectedproductName = "iMac";
		SearchPage searchPage = landingPage.getSearchPlaceholder(ExpectedproductName);
		String[] actualProduct = searchPage.getProductName();
		for (int i = 0; i < actualProduct.length; i++) {
			String actualProductName = actualProduct[i];
			System.out.println(actualProduct.length);
			System.out.println(actualProductName);
			Assert.assertEquals(actualProductName, ExpectedproductName);
		}

	}

	@Test
	public void TC_SF_002() {
		String searchProductName = "Fitbit";
		String ExpectedMessage = "There is no product that matches the search criteria.";
		SearchPage searchPage = landingPage.getSearchPlaceholder(searchProductName);
		String actualMessage = searchPage.getMessage();
		Assert.assertEquals(actualMessage, ExpectedMessage);

	}

	@Test
	public void TC_SF_003() {
		String ExpectedMessage = "There is no product that matches the search criteria.";
		SearchPage searchPage = landingPage.getSearchPlaceholder("");
		String actualMessage = searchPage.getMessage();
		Assert.assertEquals(actualMessage, ExpectedMessage);

	}

	@Test
	public void TC_SF_004() throws InterruptedException {
		String productName = "iMac";
		LoginPage loginPage = landingPage.getToLoginPage();
		MyAccountPage myAccountPage = loginPage.loginToApp(email, password);
		Thread.sleep(2000);
		SearchPage searchPage = myAccountPage.getSearchPlaceholder(productName);
		String[] actualProduct = searchPage.getProductName();
		for (int i = 0; i < actualProduct.length; i++) {
			String name = actualProduct[i];
			Assert.assertTrue(name.contains(productName));
		}
	}

	@Test
	public void TC_SF_005() {
		String productName = "Mac";
		SearchPage searchPage = landingPage.getSearchPlaceholder(productName);
		String[] actualProduct = searchPage.getProductName();
		for (int i = 0; i < actualProduct.length; i++) {
			String name = actualProduct[i];
			Assert.assertTrue(name.contains(productName));
		}

	}

	@Test
	public void TC_SF_006() {
		String expectedSearchBoxPlaceholderName = "Search";
		String expectedSearchCriteriaPlaceholderName = "Keywords";
		SearchPage searchPage = landingPage.getSearchPlaceholder("");
		String actualSearchBoxPlaceholderName = searchPage.getSearchBoxPlaceholder();
		String actualSearchCriteriaPlaceholderName = searchPage.getPlaceholderOfSearchCriteriaTextBox();
		Assert.assertEquals(actualSearchBoxPlaceholderName, expectedSearchBoxPlaceholderName);
		Assert.assertEquals(actualSearchCriteriaPlaceholderName, expectedSearchCriteriaPlaceholderName);
	}

	@Test
	public void TC_SF_007() {
		String productName = "iMac";
		SearchPage searchPage = landingPage.getSearchPlaceholder("");
		searchPage.getProductBySearchCriteriaField(productName);
		String[] actualProduct = searchPage.getProductName();
		for (int i = 0; i < actualProduct.length; i++) {
			String name = actualProduct[i];
			Assert.assertTrue(name.contains(productName));
		}

	}

	@Test
	public void TC_SF_008() {
		String productName = "iLife";
		SearchPage searchPage = landingPage.getSearchPlaceholder("");
		searchPage.getProductBySearchCriteriaFieldWithCheckBox(productName);
		String prodDescription = searchPage.getProdDescription();
		Assert.assertTrue(prodDescription.contains(productName));
	}

//	later i will fix it
	@Test
	public void TC_SF_009() throws InterruptedException {
		String productName = "iMac";
		String option = "Mac";
		SearchPage searchPage = landingPage.getSearchPlaceholder("");
		searchPage.inputSearchCriteriaField(productName);
		searchPage.getCategoryOption(option);
		String[] actualProduct = searchPage.getProductName();
		for (int i = 0; i < actualProduct.length; i++) {
			String actualProductName = actualProduct[i];
			System.out.println(actualProduct.length);
			System.out.println(actualProductName);
			Assert.assertEquals(actualProductName, productName);
		}
	}

}
