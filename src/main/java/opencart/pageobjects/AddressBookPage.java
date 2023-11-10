package opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;

public class AddressBookPage extends AbstractComponent {
	WebDriver driver;

	public AddressBookPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Add new addresss button
	@FindBy(xpath = "//a[normalize-space()='New Address']")
	WebElement NewAddressButton;

	@FindBy(css = "#input-firstname")
	WebElement InputFirstName;

	@FindBy(css = "#input-lastname")
	WebElement InputLastName;

	@FindBy(css = "#input-company")
	WebElement InputCompany;

	@FindBy(css = "#input-address-1")
	WebElement InputAddress_1;

	@FindBy(css = "#input-city")
	WebElement InputCity;

	@FindBy(css = "#input-postcode")
	WebElement InputPostalCode;

	@FindBy(css = "#input-country")
	WebElement SelectCountry;

	@FindBy(css = "#input-zone")
	WebElement SelectRegion;

	@FindBy(css = "button[type='submit']")
	WebElement SubmitButton;

	@FindBy(css = ".alert.alert-success.alert-dismissible")
	WebElement AddressAddesdSuccessfullyMsg;

	public String getSuccessMsgOfAdded() {
		return AddressAddesdSuccessfullyMsg.getText();
	}

	public void addNewAddress(String firstName, String lastName, String company, String address1, String city,
			String postCode, String countryName, String regionName) {
		waitForElementToAppear(NewAddressButton);
		NewAddressButton.click();
		InputFirstName.sendKeys(firstName);
		InputLastName.sendKeys(lastName);
		InputCompany.sendKeys(company);
		InputAddress_1.sendKeys(address1);
		InputCity.sendKeys(city);
		InputPostalCode.sendKeys(postCode);
		selectDroDown(SelectCountry, countryName);
		selectDroDown(SelectRegion, regionName);
		scrollDown(0, 300);
		SubmitButton.click();
	}
}
