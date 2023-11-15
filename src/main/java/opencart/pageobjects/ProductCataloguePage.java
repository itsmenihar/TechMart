package opencart.pageobjects;

import java.util.ArrayList;
import java.util.List;

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

	@FindBy(css = "div[class='description'] h4 a")
	List<WebElement> prod;

	public String[] getProductName() {
	    waitForElementsToAppear(prod);

	    // Assuming prod is a list of WebElements
	    List<String> prodNamesList = new ArrayList<String>();

	    for (WebElement e : prod) {
	        String prodName = e.getText();
	        prodNamesList.add(prodName);
	    }

	    // Convert the list to an array
	    String[] prodNamesArray = prodNamesList.toArray(new String[0]);

	    return prodNamesArray;
	}

	@FindBy(css = "div[id='content'] p")
	WebElement DisplayMessage;

	public String getMessage() {
		return DisplayMessage.getText();
	}
}
