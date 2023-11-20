package opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.DesktopsPage;
import opencart.pageobjects.ProductComparisonPage;
import opencart.pageobjects.ProductPage;
import opencart.pageobjects.SearchPage;

public class ProductComparisonFunctionalityTest extends BaseTest {
	WebDriver driver;

	String expectedProductName = "iMac";
	String expectedToolTip = "Compare this Product";
	String expectedSuccessMsg = "Success: You have added iMac to your product comparison!";
	String expectedTitleOfPage = "Product Comparison";

	@Test
	public void TC_PC_001() {

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

	@Test
	public void TC_PC_002() throws InterruptedException {
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		searchPage.getListViewBtn();
		String actualToolTip = searchPage.getCompareThisProductToolTips();
		Assert.assertEquals(actualToolTip, expectedToolTip);
		String actualSuccessMsg = searchPage.getSuccessMsg();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
		ProductComparisonPage prodComparisonPage = searchPage.goToComparisonPage();
		String actualTitleOfPage = prodComparisonPage.getTitleOfPage();
		Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);
	}

	@Test
	public void TC_PC_003() throws InterruptedException {
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		searchPage.getGridViewBtn();
		String actualToolTip = searchPage.getCompareThisProductToolTips();
		Assert.assertEquals(actualToolTip, expectedToolTip);
		String actualSuccessMsg = searchPage.getSuccessMsg();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
		ProductComparisonPage prodComparisonPage = searchPage.goToComparisonPage();
		String actualTitleOfPage = prodComparisonPage.getTitleOfPage();
		Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);
	}

	@Test
	public void TC_PC_004() throws InterruptedException {
		String expectedSuccessMsg = "Success: You have added Apple Cinema 30\" to your product comparison!";
		
		DesktopsPage desktopsPage = landingPage.getAllDesktopsFromNavBar();
		desktopsPage.getListViewBtn();
		String actualToolTip = desktopsPage.getCompareThisProductToolTips();
		Assert.assertEquals(actualToolTip, expectedToolTip);
		String actualSuccessMsg = desktopsPage.getSuccessMsg();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
		ProductComparisonPage prodComparisonPage = desktopsPage.goToComparisonPage();
		String actualTitleOfPage = prodComparisonPage.getTitleOfPage();
		Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);

	}
}
