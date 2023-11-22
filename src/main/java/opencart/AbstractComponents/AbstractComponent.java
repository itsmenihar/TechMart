package opencart.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import opencart.pageobjects.DesktopsPage;
import opencart.pageobjects.LoginPage;
import opencart.pageobjects.ProductComparisonPage;
import opencart.pageobjects.RegistrationPage;
import opencart.pageobjects.SearchPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// all header elements on opencart

	// My Account dropdown element
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccount;

	// Register element
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement Register;

	// Login element
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement Login;
	// Search box element present in the header
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement SearchBox;
	// search icon button present on the header right side of the search box
	@FindBy(xpath = "//button[@class='btn btn-light btn-lg']")
	WebElement SearchButton;

	public SearchPage getSearchPlaceholder(String productName) {
		SearchBox.sendKeys(productName);
		SearchButton.click();
		SearchPage searchPage = new SearchPage(driver);
		return searchPage;
	}

	public String getSearchBoxPlaceholder() {
		return SearchBox.getAttribute("placeholder");
	}

	public RegistrationPage getToRegistrationPage() {
		MyAccount.click();
		Register.click();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		return registrationPage;
	}

	public LoginPage getToLoginPage() {
		MyAccount.click();
		Login.click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}

	public void scrollDown(int x, int y) {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(x, y).perform();
	}

	public void waitElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForElementsToAppear(List<WebElement> ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	public void selectDroDown(WebElement ele, String name) {
		Select drpDownList = new Select(ele);
		drpDownList.selectByVisibleText(name);
	}

	public void waitForElementToStale(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.stalenessOf(ele));
	}

	// success message element popup on the right side upper corner
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;

	public WebElement getSuccessMessage() {
		return successMsg;
	}

	// tool tip element of "compare this product"
	@FindBy(css = ".tooltip-inner")
	WebElement ToolTipCompareThisProd;

	public WebElement getToolTipCompareThisProd() {
		return ToolTipCompareThisProd;
	}

	/*
	 * product comparison link present in the success message after clicking on
	 * "compare this product" element
	 */
	@FindBy(xpath = "//a[normalize-space()='product comparison']")
	WebElement ProductComparisonLinkOnMsg;

	public WebElement getProductComparisonLinkOnMsg() {
		return ProductComparisonLinkOnMsg;
	}

	// "compare this product" element present on product list
	@FindBy(xpath = "//div[@class='button-group']//button[3]")
	WebElement compareThisProdElement;

	public WebElement getCompareThisProdElement() {
		return compareThisProdElement;
	}

	// capture tool tip text by actions class by scrolling 400 in y axis
	public String getCompareThisProductToolTips() {
		scrollDown(0, 400);
		waitForElementToAppear(getCompareThisProdElement());
		Actions ac = new Actions(driver);
		ac.moveToElement(getCompareThisProdElement()).perform();
		String toolTipText = getToolTipCompareThisProd().getText();
		return toolTipText;
	}

	// capture tool tip text by actions class by scrolling 900 in y axis
	public String getCompareThisProductToolTipsOfRelatedProd() {
		scrollDown(0, 900);
		waitForElementToAppear(getCompareThisProdElement());
		Actions ac = new Actions(driver);
		ac.moveToElement(getCompareThisProdElement()).perform();
		String toolTipText = getToolTipCompareThisProd().getText();
		return toolTipText;
	}

	// geting success message of adding the product to comparison
	public String getSuccessMsgOfAdding() {
		waitForElementToAppear(getCompareThisProdElement());
		getCompareThisProdElement().click();
		waitForElementToAppear(getSuccessMessage());
		String msg = getSuccessMessage().getText();
		return msg;
	}

	/*
	 * going to comparison page after clicking on the "product comparison" link in
	 * success message
	 */
	public ProductComparisonPage goToComparisonPage() {
		getProductComparisonLinkOnMsg().click();
		ProductComparisonPage prodComparisonPage = new ProductComparisonPage(driver);
		return prodComparisonPage;
	}

	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	WebElement NavDesktops;

	@FindBy(xpath = "//a[normalize-space()='Show All Desktops']")
	WebElement ShowAllDesktops;

	public DesktopsPage getAllDesktopsFromNavBar() {
		Actions act = new Actions(driver);
		act.moveToElement(NavDesktops).moveToElement(ShowAllDesktops).click().perform();
		DesktopsPage desktopsPage = new DesktopsPage(driver);
		return desktopsPage;
	}

	@FindBy(id = "button-list")
	WebElement ListViewButton;

	public void getListViewBtn() throws InterruptedException {
		ListViewButton.click();
		Thread.sleep(2000);
	}

	@FindBy(id = "button-grid")
	WebElement GridViewButton;

	public void getGridViewBtn() throws InterruptedException {
		GridViewButton.click();
		Thread.sleep(2000);
	}

}
