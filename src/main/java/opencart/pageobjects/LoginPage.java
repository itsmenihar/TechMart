package opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;



public class LoginPage extends AbstractComponent {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Email input field element 
	@FindBy(id = "input-email")
	WebElement InputEmail;

//Password input field element
	@FindBy(id = "input-password")
	WebElement InputPassword;

//Login button element
	@FindBy(css = "button[type='submit']")
	WebElement loginBtn;

//valid email and invalid password(less than 3 characters)
	@FindBy(css = ".alert.alert-danger.alert-dismissible")
	WebElement ErrorWarningForLogin;

	public String getErrorWarningForLogin() {
		waitForElementToAppear(ErrorWarningForLogin);
		return ErrorWarningForLogin.getText();
	}

	public MyAccountPage loginToApp(String email, String password) {
		InputEmail.sendKeys(email);
		InputPassword.sendKeys(password);
		loginBtn.click();
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		return myAccountPage;
	}
}
