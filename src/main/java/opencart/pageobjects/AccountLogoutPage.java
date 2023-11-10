package opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;



public class AccountLogoutPage extends AbstractComponent {
	WebDriver driver;

	public AccountLogoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement ContinueButton;
	
	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	WebElement LogoutMsg;
	
	public String getText() {
		return LogoutMsg.getText();
	}

	public LandingPage getContinueButton() {
		ContinueButton.click();
		LandingPage landingPage = new LandingPage(driver);
		return landingPage;
	}
}
