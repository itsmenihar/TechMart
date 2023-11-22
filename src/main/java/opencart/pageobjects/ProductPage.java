package opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;

public class ProductPage extends AbstractComponent {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	"compare this product" element after clicking on the product
	@FindBy(xpath = "//div[@class='col-sm']//form//button[2]")
	WebElement compareThisProd;

	public WebElement getCompareThisProd() {
		return compareThisProd;
	}

//	hover "compare this product" element and get the text of tooltip in product
	public String getToolTip() {
		waitForElementToAppear(getCompareThisProd());
		Actions action = new Actions(driver);
		action.moveToElement(getCompareThisProd()).perform();
		String toolTipText = getToolTipCompareThisProd().getText();
		return toolTipText;
	}

//	to get the success message after clicking on the "compare this product" option in the product
	public String getSuccessMsg() {
		waitForElementToAppear(getCompareThisProd());
		compareThisProd.click();
		waitForElementToAppear(getSuccessMessage());
		String msg = getSuccessMessage().getText();
		return msg;
	}

}
