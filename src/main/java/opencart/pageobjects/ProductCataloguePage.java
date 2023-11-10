package opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;



public class ProductCataloguePage extends AbstractComponent {
	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='description']//h4")
	WebElement productName;
	
	public String getProductName() {
		return productName.getText();
	}
}
