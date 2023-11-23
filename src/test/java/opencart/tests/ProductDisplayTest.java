package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.ProductPage;
import opencart.pageobjects.SearchPage;

public class ProductDisplayTest extends BaseTest {
	WebDriver driver;
	String expectedProductName = "iMac";

	// Validate the Thumbnails of the Product displayed in the Product Display Page
	@Test
	public void TC_PDP_001() {

		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductPage productPage = searchPage.getProduct();
		productPage.goToLightBoxView();
		Assert.assertTrue(productPage.getLightBoxView().isDisplayed());
		Assert.assertTrue(productPage.getLeftArrowKey().isDisplayed());
		Assert.assertTrue(productPage.getRightArrowKey().isDisplayed());
		productPage.getCloseButton();
		Assert.assertTrue(productPage.getProductThumbnail().isDisplayed());
	}

	@Test
	public void TC_PDP_002() {
		String expectedBrandName = "Apple";
		String expectedProductCode = "Product Code: Product 14";
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductPage productPage = searchPage.getProduct();
		String actualProductName = productPage.getProductNameFromDescription();
		Assert.assertEquals(actualProductName, expectedProductName);
		String actualBrandName = productPage.getBrandNameFromDescription();
		Assert.assertEquals(actualBrandName, expectedBrandName);
		String actualProductCode = productPage.getProductCodeFromDescription();
		Assert.assertEquals(actualProductCode, expectedProductCode);
	}
}
