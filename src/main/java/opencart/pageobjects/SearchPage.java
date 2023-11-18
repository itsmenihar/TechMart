package opencart.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import opencart.AbstractComponents.AbstractComponent;

public class SearchPage extends AbstractComponent {
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		super(driver);
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

	@FindBy(xpath = "//input[@id='input-search']")
	WebElement SearchCriteria;

	@FindBy(id = "button-search")
	WebElement SearchButton;;

	public String getPlaceholderOfSearchCriteriaTextBox() {
		return SearchCriteria.getAttribute("placeholder");
	}

	public void getProductBySearchCriteriaField(String productName) {
		SearchCriteria.sendKeys(productName);
		SearchButton.click();
	}

	public void inputSearchCriteriaField(String productName) {
		SearchCriteria.sendKeys(productName);
	}

	@FindBy(id = "input-description")
	WebElement PDescriptionCheckBox;

	@FindBy(css = "h4 a")
	WebElement ProductItem;

	public void getProductBySearchCriteriaFieldWithCheckBox(String productName) {
		SearchCriteria.sendKeys(productName);
		PDescriptionCheckBox.click();
		SearchButton.click();
		scrollDown(0, 300);
		ProductItem.click();
	}

	@FindBy(css = "div[id='tab-description'] div")
	WebElement ProdDescription;

	public String getProdDescription() {
		return ProdDescription.getText();
	}

	@FindBy(xpath = "//select[@id='input-category']")
	WebElement InputCategory;

	@FindBy(xpath = "//select[@id='input-category']//option")
	List<WebElement> dropDownList;

	public void getOption(String category) throws InterruptedException {
		InputCategory.click();
		Thread.sleep(3000);
		selectDropDownList(dropDownList, category);
		Thread.sleep(3000);
		SearchButton.click();
	}

	@FindBy(xpath="//img[@title='iMac']")
	WebElement productImg;

	public ProductPage getProduct() {
		waitForElementToAppear(productImg);
		scrollDown(0, 100);
		productImg.click();
		ProductPage productPage = new ProductPage(driver);
		return productPage;
	}

	
	
	//dynamic for each loop for dropdown list
	public static void selectDropDownList(List<WebElement> options, String value) {
		for (WebElement option : options) {
			if (option.getText().endsWith(value)) {
				option.click();
				break;
			}
		}
	}
}
