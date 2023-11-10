package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.ProductCataloguePage;

public class SearchFunctionalityTest extends BaseTest {
	WebDriver driver;

	@Test
	public void searchProductByExistingName() {
		String ExpectedproductName = "iMac";
		ProductCataloguePage productCataloguePage = landingPage.getSearchPlaceholder(ExpectedproductName);
		String actualProduct = productCataloguePage.getProductName();
		Assert.assertEquals(actualProduct, ExpectedproductName);
	}

}
