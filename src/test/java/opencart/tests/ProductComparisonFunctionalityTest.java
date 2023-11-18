package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.ProductComparisonPage;
import opencart.pageobjects.ProductPage;
import opencart.pageobjects.SearchPage;

public class ProductComparisonFunctionalityTest extends BaseTest {
	WebDriver driver;

	@Test
	public void TC_PC_001() {
		String expectedProductName = "iMac";
		String expectedToolTip = "Compare this Product";
		String expectedSuccessMsg = "Success: You have added iMac to your product comparison!";
		String expectedTitleOfPage = "Product Comparison";

		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductPage productPage = searchPage.getProduct();
		String actualToolTip = productPage.getToolTip();
		Assert.assertEquals(actualToolTip, expectedToolTip);
		String actualSuccessMsg = productPage.getSuccessMsg();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
		ProductComparisonPage prodComparisonPage = productPage.goToComparisonPage();
		String actualTitleOfPage = prodComparisonPage.getTitleOfPage();
		Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);
	}
}
