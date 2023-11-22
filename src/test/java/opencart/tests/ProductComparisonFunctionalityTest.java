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
	String expectedSuccessMessage = "Success: You have added iMac to your product comparison!";
	String expectedTitleOfPage = "Product Comparison";

	@Test
	public void TC_PC_001() {

		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductPage productPage = searchPage.getProduct();
		String actualToolTip = productPage.getToolTip();
		Assert.assertEquals(actualToolTip, expectedToolTip);
		String actualSuccessMsg = productPage.getSuccessMsg();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMessage);
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
		String actualSuccessMsg = searchPage.getSuccessMsgOfAdding();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMessage);
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
		String actualSuccessMsg = searchPage.getSuccessMsgOfAdding();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMessage);
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
		String actualSuccessMsg = desktopsPage.getSuccessMsgOfAdding();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
		ProductComparisonPage prodComparisonPage = desktopsPage.goToComparisonPage();
		String actualTitleOfPage = prodComparisonPage.getTitleOfPage();
		Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);

	}

	@Test
	public void TC_PC_005() throws InterruptedException {
		String expectedSuccessMsg = "Success: You have added Apple Cinema 30\" to your product comparison!";

		DesktopsPage desktopsPage = landingPage.getAllDesktopsFromNavBar();
		desktopsPage.getGridViewBtn();
		String actualToolTip = desktopsPage.getCompareThisProductToolTips();
		Assert.assertEquals(actualToolTip, expectedToolTip);
		String actualSuccessMsg = desktopsPage.getSuccessMsgOfAdding();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
		ProductComparisonPage prodComparisonPage = desktopsPage.goToComparisonPage();
		String actualTitleOfPage = prodComparisonPage.getTitleOfPage();
		Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);
	}

	@Test
	public void TC_PC_006() {
		String expectedSuccessMsg = "Success: You have added Apple Cinema 30\" to your product comparison!";
		String expectedProdNameInComparison = "Apple Cinema 30\"";
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductPage productPage = searchPage.getProduct();
		String actualToolTip = productPage.getCompareThisProductToolTipsOfRelatedProd();
		Assert.assertEquals(actualToolTip, expectedToolTip);
		String actualSuccessMsg = productPage.getSuccessMsgOfAdding();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
		ProductComparisonPage prodComparisonPage = productPage.goToComparisonPage();
		String actualProdNameInComparison = prodComparisonPage.getAddedProdNameToComparison();
		Assert.assertEquals(actualProdNameInComparison, expectedProdNameInComparison);
	}

	@Test
	public void TC_PC_007() {
		String expectedSuccessMsg = "Success: You have added MacBook to your product comparison!";
		String expectedProdNameInComparison = "MacBook";
		String actualToolTip = landingPage.getCompareThisProductToolTipsOfRelatedProd();
		Assert.assertEquals(actualToolTip, expectedToolTip);
		landingPage.getCompareThisProdElement();
		String actualSuccessMsg = landingPage.getSuccessMsgOfAdding();
		Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
		ProductComparisonPage prodComparisonPage = landingPage.goToComparisonPage();
		String actualProdNameInComparison = prodComparisonPage.getAddedProdNameToComparison();
		Assert.assertEquals(actualProdNameInComparison, expectedProdNameInComparison);
	}

	@Test
	public void TC_PC_008() {
		SearchPage searchPage = landingPage.getSearchPlaceholder(expectedProductName);
		ProductComparisonPage productComparisonPage = searchPage.goToProductComparisonPageByProductCompareButton();
		String actualTitleOfPage = productComparisonPage.getTitleOfPage();
		Assert.assertEquals(actualTitleOfPage, expectedTitleOfPage);
	}
}
