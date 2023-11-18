package opencart.pageobjects;

import org.openqa.selenium.WebDriver;
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

}
