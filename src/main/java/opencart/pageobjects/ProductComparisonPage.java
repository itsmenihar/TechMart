package opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;

public class ProductComparisonPage extends AbstractComponent {
	WebDriver driver;

	public ProductComparisonPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitleOfPage() {
		String title = driver.getTitle();
		return title;
	}

	// added product name in the comparison
	@FindBy(xpath = "(//tbody//tr[1]//td[2])[1]")
	WebElement AddedProdToComparison;

	public String getAddedProdNameToComparison() {
		return AddedProdToComparison.getText();
	}

}
