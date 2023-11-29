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

	// product thumbnail
	@FindBy(xpath = "//img[@class='img-thumbnail mb-3']")
	WebElement ProdThumbnail;

	// after clicking on the big size product thumbnail
	public void goToLightBoxView() {
		ProdThumbnail.click();
		;
	}

	public WebElement getProductThumbnail() {
		return ProdThumbnail;
	}

	// product light box view
	@FindBy(xpath = "//img[@class='mfp-img']")
	WebElement LightBoxView;

	public WebElement getLightBoxView() {
		return LightBoxView;
	}

	// left arrow key on Light box view
	@FindBy(xpath = "//button[@title='Previous (Left arrow key)']")
	WebElement LeftArrowKey;

	public WebElement getLeftArrowKey() {
		return LeftArrowKey;
	}

	// right arrow key on Light box view
	@FindBy(xpath = "//button[@title='Next (Right arrow key)']")
	WebElement RightArrowKey;

	public WebElement getRightArrowKey() {
		return RightArrowKey;
	}

	// close or Esc button on light box view
	@FindBy(css = "button[title='Close (Esc)']")
	WebElement CloseButton;

	public WebElement getCloseButton() {
		return CloseButton;
	}

	// product name
	@FindBy(css = "div[class='col-sm'] h1")
	WebElement productName;

	public String getProductNameFromDescription() {
		return productName.getText();
	}

	// Brand name
	@FindBy(xpath = "//div[@class='row mb-3']//ul[@class='list-unstyled']//li[1]//a")
	WebElement brandName;

	public String getBrandNameFromDescription() {
		return brandName.getText();
	}

	// product code of iMac
	@FindBy(xpath = "//li[normalize-space()='Product Code: Product 14']")
	WebElement productCode;

	public String getProductCodeFromDescription() {
		return productCode.getText();
	}

	// product availability of iMac
	@FindBy(xpath = "//li[normalize-space()='Availability: In Stock']")
	WebElement ProductAvailability;

	public String getProductAvailabilityFromDescription() {
		return ProductAvailability.getText();
	}

	// product price
	@FindBy(xpath = "//ul[@class='list-unstyled']//li//h2")
	WebElement ProductPrice;

	public String getProductPriceFromDescription() {
		return ProductPrice.getText();
	}

	// product tax price of iMac product
	@FindBy(xpath = "//li[normalize-space()='Ex Tax: $100.00']")
	WebElement iMacTaxPrice;

	public String getiMacTaxPrice() {
		return iMacTaxPrice.getText();
	}

	// product quantity in product display page
	@FindBy(id = "input-quantity")
	WebElement productQuantity;

	public WebElement getInputFieldQuantity() {
		return productQuantity;
	}

	// add to cart button
	@FindBy(css = "#button-cart")
	WebElement addToCartButton;

	// success message for adding product to shopping cart
	@FindBy(css = ".alert.alert-success.alert-dismissible")
	WebElement addingToShoppingCartMsg;

	public String getAddingToShoppingCartMsg() {
		return addingToShoppingCartMsg.getText();
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public String getProductQuantity() {
		return productQuantity.getAttribute("value");
	}

	// increase product quantity above 1 and adding the product to shopping cart,
	// capture the success message
	public String inputProductQuantity(String Qnty) {
		productQuantity.clear();
		productQuantity.sendKeys(Qnty);
		addToCartButton.click();
		return addingToShoppingCartMsg.getText();
	}

	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	WebElement shoppingCartLink;

	// click on the shopping cart link in success message of adding product to cart
	public ShoppinCartPage getShoppingCartPage() {
		shoppingCartLink.click();
		ShoppinCartPage shoppinCartPage = new ShoppinCartPage(driver);
		return shoppinCartPage;
	}

}
