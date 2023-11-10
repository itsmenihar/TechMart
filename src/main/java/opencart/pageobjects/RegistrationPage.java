package opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;



public class RegistrationPage extends AbstractComponent {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//Registration Form

//firstname input box element
	@FindBy(id = "input-firstname")
	WebElement InputFirstName;

//lastname input box element
	@FindBy(id = "input-lastname")
	WebElement InputLastName;

//email input box element
	@FindBy(id = "input-email")
	WebElement InputEMail;

//password input box element
	@FindBy(id = "input-password")
	WebElement InputPassword;

//subscribe newletter toggle element
	@FindBy(id = "input-newsletter")
	WebElement ToggleSubscribe;

//privacy Policy toggle element
	@FindBy(name = "agree")
	WebElement Aggrement;

//Submit button of registration form
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement SubmitButton;

//aggrement warning
	@FindBy(xpath = "//dirv[@class='alert alert-danger alert-dismissible']")
	WebElement AggrementWarning;

//password feedback element
	By ErrorFeedbackPassword = By.id("error-password");

//First name error feedback element
	By ErrorFeedbackFirstName = By.id("error-firstname");

// Last name error feedback element
	By ErrorFeedbackLastName = By.id("error-lastname");

	public String getErrorFeedbackPassword() {
		waitElementToAppear(ErrorFeedbackPassword);
		return driver.findElement(ErrorFeedbackPassword).getText();
	}

	public String getErrorFeedbackFirstName() {
		waitElementToAppear(ErrorFeedbackFirstName);
		return driver.findElement(ErrorFeedbackFirstName).getText();
	}
	
	public String getErrorFeedbackLastName() {
		waitElementToAppear(ErrorFeedbackLastName);
		return driver.findElement(ErrorFeedbackLastName).getText();
	}

	public MyAccountPage registrationToApp(String firstName, String lastName, String email, String password) {
		InputFirstName.sendKeys(firstName);
		InputLastName.sendKeys(lastName);
		InputEMail.sendKeys(email);
		InputPassword.sendKeys(password);
		scrollDown(0, 200);
		Aggrement.click();
		SubmitButton.click();
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		return myAccountPage;

	}

	public String getValidationMsgToolTip() {
		return InputEMail.getAttribute("validationMessage");
	}
}
