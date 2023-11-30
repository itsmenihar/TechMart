package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.ProductPage;
import opencart.pageobjects.SearchPage;
import opencart.pageobjects.ShoppinCartPage;

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

	@Test
	public void TC_PDP_003() {
		String expectedAvailabilityMsg = "Availability: In Stock";
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductPage productPage = searchPage.getProduct();
		String actualAvailabilityMsg = productPage.getProductAvailabilityFromDescription();
		Assert.assertEquals(actualAvailabilityMsg, expectedAvailabilityMsg);
	}

	@Test
	public void TC_PDP_004() {
		String expectedProductPrice = "$122.00";
		String expectedTaxPrice = "Ex Tax: $100.00";
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductPage productPage = searchPage.getProduct();
		String actualProductPrice = productPage.getProductPriceFromDescription();
		Assert.assertEquals(actualProductPrice, expectedProductPrice);
		String actualTaxPrice = productPage.getiMacTaxPrice();
		Assert.assertEquals(actualTaxPrice, expectedTaxPrice);
	}

	@Test
	public void TC_PDP_005() {
		String expectedMessage = "Success: You have added iMac to your shopping cart!";
		String expectedQuantityInCart = "2";
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductPage productPage = searchPage.getProduct();
		String actualQuantity = productPage.getProductQuantity();
		Assert.assertTrue(actualQuantity.equalsIgnoreCase("1"));
		String actualMessage = productPage.inputProductQuantity("2");
		Assert.assertEquals(actualMessage, expectedMessage);
		ShoppinCartPage shoppingCartPage = productPage.getShoppingCartPage();
		String actualQuantityInCart = shoppingCartPage.getQuntityValue();
		Assert.assertEquals(actualQuantityInCart, expectedQuantityInCart);
	}

	@Test
	public void TC_PDP_006() throws InterruptedException {
		String[] quantities = { "", "0", "-2" };
		String expectedMessage = "Quantity should be a positive number' or 'Quantity cannot be zero, null or negative";
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductPage productPage = searchPage.getProduct();
		String actualQuantity = productPage.getProductQuantity();
		Assert.assertTrue(actualQuantity.equalsIgnoreCase("1"));
		SoftAssert softassert = new SoftAssert();
		for (String quantity : quantities) {
			productPage.getInputFieldQuantity().clear();
			Thread.sleep(2000);
			productPage.getInputFieldQuantity().sendKeys(quantity);
			Thread.sleep(2000);
			productPage.getAddToCartButton().click();
			;
			String actualMessage = productPage.getAddingToShoppingCartMsg();
			Thread.sleep(2000);
			softassert.assertEquals(actualMessage, expectedMessage);
			softassert.assertAll();
		}

	}

	@Test
	public void TC_PDP_007() {
		String expectedProdName = "Apple Cinema 30\"";
		String expectedTextUnderAddToCartBtn = "This product has a minimum quantity of 2";
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProdName);
		ProductPage productPage = searchPage.getProduct();
		String actualQuantity = productPage.getProductQuantity();
		Assert.assertTrue(actualQuantity.equalsIgnoreCase("2"));
		String actualTextUnderAddToCartBtn = productPage.getTextUnderAddToCartButton();
		Assert.assertEquals(actualTextUnderAddToCartBtn, expectedTextUnderAddToCartBtn);
		productPage.scrollDown(0, 200);
		productPage.getDesiredRadioOption("Medium (+$26.00)");
		productPage.scrollDown(0, 200);
		productPage.getDesiredCheckbox("Checkbox 2 (+$26.00)");
		productPage.scrollDown(0, 200);
		productPage.getDesiredColor("Blue (+$5.60)");
	}
}
