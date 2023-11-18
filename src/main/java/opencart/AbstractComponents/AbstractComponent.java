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

import opencart.pageobjects.LoginPage;
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

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement SearchBox;

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
}
