package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*
 * This Class has webelement required for payment process of Air Conditioner module
 * 
 *  @author Saravanan, Arumugam
 */
public class ACPaymentPage {
	
	// "driver" is an instance for WebDriver Class
	WebDriver driver = null;
	
	//"builder" is an instance for Actions Class
	Actions builder = null;
	
	//"addToCart" is an instance for "Add to Cart" button
	@FindBy(xpath = "//span[text()='Add to cart']") WebElement addToCart;
	
	//"chkout" is an instance for "Checkout" button
	@FindBy(xpath = "//span[text()='Checkout']") WebElement chkout;
	
	//"asAGuest" is an instance for "As a Guest" button
	@FindBy(xpath = "//span[text()='Checkout as Guest']") WebElement asAGuest;
	
	//"firstName" is an instance for "First Name" text box
	@FindBy(xpath = "//input[@id='NewAddress_FirstName']") WebElement firstName;
	
	//"lastName" is an instance for "Last Name" text box
	@FindBy(xpath = "//input[@id='NewAddress_LastName']") WebElement lastName;
	
	//"address" is an instance for "Address" text box
	@FindBy(xpath = "//input[@id='NewAddress_Address1']") WebElement address;
	
	//"city" is an instance for "City" text box
	@FindBy(xpath = "//input[@id='NewAddress_City']") WebElement city;
	
	//"zipcode" is an instance "Zip Code" text box
	@FindBy(xpath = "//input[@id='NewAddress_ZipPostalCode']") WebElement zipcode;
	
	//"country" is an instance for "Country" drop down box
	@FindBy(xpath = "//select[@id='NewAddress_CountryId']") WebElement country;
	
	//"email" is an instance for "Email" text box
	@FindBy(xpath = "//input[@id='NewAddress_Email']") WebElement email;
	
	//"phoneNo" is an instance for "Phone Number" text box 
	@FindBy(xpath = "//input[@id='NewAddress_PhoneNumber']") WebElement phoneNo;
	
	//"nxtButton" is an instance for "Next" Button
	@FindBy(xpath = "//button/span[text()='Next']") WebElement nxtButton;
	
	//"shipAddr" is instance for "Shipping to this Address" button
	@FindBy(xpath = "//button/span[text()='Ship to this address']") WebElement shipAddr;
	
	//"byGroundRBtn" is an instance for "By Ground" radio button
	@FindBy(xpath = "//input[@id='shippingoption_1']") WebElement byGroundRBtn;
	
	/*
	 * The constructor  "ACPaymentPage" does initialize the webdriver and
	 * action class objects, initialize the PageFactory for ACPaymentPage
	 * web page
	 * 
	 * @param driver - Receives webdriver object
	 */
	public ACPaymentPage(WebDriver driver) {
		this.driver = driver;
		builder = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Clicks the each Air Conditioner Product by using it's xpath and returns
	 * false if "Add to Cart" button is clicked else it returns true if "Add to Cart" button
	 * is found missing in the web page DOM.
	 * 
	 * @return - boolean value 
	 * 
	 * @throws NoSuchElementException if webelement is found missing
	 */
	public boolean forPayment() {
		try {
			builder.moveToElement(addToCart).click().build().perform();
		}
		catch(NoSuchElementException e) {
			return true;
		}
		return false;
	}
	
	/*
	 * Clicks on "Check Out"  and "As a Guest" button
	 */
	public void checkoutProcess() {
		chkout.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		builder.moveToElement(asAGuest).click().build().perform();
	}
	
	/*
	 * Sends the received data to corresponding text box and drop down box
	 * 
	 * @param i - To choose specific text box or drop down in the web page for sending data
	 * @param data - Actual data to be passed
	 */
	public void sendDetails(int i,String data) {
		switch(i) {
			case 1 : firstName.sendKeys(data); break;
			case 2 : lastName.sendKeys(data); break;
			case 3 : address.sendKeys(data); break;
			case 4 : city.sendKeys(data); break;
			case 5 : zipcode.sendKeys(data); break;
			case 6:  Select slt =   new Select(country); slt.selectByVisibleText(data); break;
			case 7 : email.sendKeys(data); break;
			case 8 : phoneNo.sendKeys(data); break;
			default:
		}
	}
	
	/*
	 * Clicks "Next" button in the web page
	 */
	public void toNext() {
		builder.moveToElement(nxtButton).click().build().perform();
	}
	
	/*
	 * Clicks "Shipping to this Address" and "By Ground" buttons
	 */
	public void confirmShipping() {
		builder.moveToElement(shipAddr).click().build().perform();
		builder.moveToElement(byGroundRBtn).click().build().perform();
	}
	
	/*
	 * Returns Current URL of the web page
	 * 
	 * @returns String - Current URL directly
	 */
	public String toGetCurtURL() {
		return driver.getCurrentUrl();
	}
}
