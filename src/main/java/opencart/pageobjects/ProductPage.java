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

	@FindBy(xpath = "//div[@class='col-sm']//form//button[2]")
	WebElement compareThisProd;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;

	@FindBy(css = ".tooltip-inner")
	WebElement ToolTipCompareThisProd;
	
	@FindBy(xpath="//a[normalize-space()='product comparison']")
	WebElement ProductComparisonLinkOnMsg;

	public String getToolTip() {
		waitForElementToAppear(compareThisProd);
		Actions action = new Actions(driver);
		action.moveToElement(compareThisProd).perform();
		String toolTipText = ToolTipCompareThisProd.getText();
		return toolTipText;
	}

	public String getSuccessMsg() {
		waitForElementToAppear(compareThisProd);
		compareThisProd.click();
		waitForElementToAppear(successMsg);
		String msg = successMsg.getText();
		return msg;
	}
	
	public ProductComparisonPage goToComparisonPage() {
		ProductComparisonLinkOnMsg.click();
		ProductComparisonPage prodComparisonPage = new ProductComparisonPage(driver);
		return prodComparisonPage;
	}

}
