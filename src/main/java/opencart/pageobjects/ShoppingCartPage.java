package opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;

public class ShoppingCartPage extends AbstractComponent {
	WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//product quantity 
	@FindBy(name = "quantity")
	WebElement quantityField;
	
	public String getQuntityValue() {
		return quantityField.getAttribute("value");
	}

}
