package opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;



public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement SearchBox;

	@FindBy(xpath = "//button[@class='btn btn-light btn-lg']")
	WebElement SearchButton;

	public ProductCataloguePage getSearchPlaceholder(String productName) {
		SearchBox.sendKeys(productName);
		SearchButton.click();
		ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);
		return productCataloguePage;
	}

	public void goTo() {
		driver.get("http://localhost:8085/apps/techmart");
	}
}
