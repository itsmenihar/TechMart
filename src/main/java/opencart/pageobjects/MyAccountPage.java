package opencart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;



public class MyAccountPage extends AbstractComponent {
	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Welcome message element for new registration
	By regdSuccessMsg = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

//My order element 
	By myOrder = By.xpath("//h2[normalize-space()='My Orders']");

//Add address button in myaccount page
	@FindBy(xpath = "//a[normalize-space()='Address Book']")
	WebElement AddressBookElement;
	
//LogOut webelement from right side menu
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement LogoutButton;
	
	public AccountLogoutPage getLogOut() throws InterruptedException {
		Thread.sleep(2000);
		scrollDown(0, 500);
		LogoutButton.click();
		AccountLogoutPage accountLogoutPage = new AccountLogoutPage(driver);
		return accountLogoutPage;
	}
	
	public AddressBookPage getAddressBook() {
		waitForElementToAppear(AddressBookElement);
		AddressBookElement.click();
		AddressBookPage addressBookPage = new AddressBookPage(driver);
		return addressBookPage;
	}
	

	public String getMyAccountTitle() {
		waitElementToAppear(myOrder);
		return driver.getTitle();
	}

	public String getSuccessMsg() {
		waitElementToAppear(regdSuccessMsg);
		return driver.findElement(regdSuccessMsg).getText();

	}
}
