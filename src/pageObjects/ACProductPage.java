package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import interfacePack.Product;

/*
 * This Class has all the webelements for each Air Conditioner
 * product web page and implements Product interface
 * 
 *  @author Saravanan, Arumugam
 */
public class ACProductPage implements Product {
	
	// "driver" is an instance for WebDriver Class
	WebDriver driver = null;
	
	//"specCount" is a public variable for number of specification count of Air Conditioner product
	public int specCount = 9;
	
	//"ACName" is a public instance for "Name" label
	@FindBy(xpath = "//h1") public WebElement ACName;
	
	//"ACPrice" is a public instance for "Price" label
	@FindBy(xpath = "//meta[@itemprop='price']") public WebElement ACPrice;
	
	//"ACDiscount" is a public instance for "Discount label"
	@FindBy(xpath = "//span[@class='pd-saving-percent']") public WebElement ACDiscount;
	
	//"ClickFeatures" is a public instance for "Click Features" link
	@FindBy(xpath = "//a[text()='Features']")public WebElement ClickFeatures;
	
	//"ACBrand" is a public instance for "Brand Name" label
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")public WebElement ACBrand;
	
	//"ACType" is a public instance for "Type" label
	@FindBy(xpath = "//table/tbody/tr[2]/td[2]")public WebElement ACType;
	
	//"ACModelCode" is a public instance for "Model Code" label
	@FindBy(xpath = "//table/tbody/tr[3]/td[2]") public WebElement ACModelCode;
	
	//"ACCapacity" is a public instance for "Capacity" label
	@FindBy(xpath = "//table/tbody/tr[4]/td[2]")public WebElement ACCapacity;
	
	//"ACStarRating" is a public instance for "Star Rating" label
	@FindBy(xpath = "//table/tbody/tr[5]/td[2]")public  WebElement ACStarRating;
	
	//"ACColour" is a public insance for "Color" label
	@FindBy(xpath = "//table/tbody/tr[9]/td[2]") public WebElement ACColour;
	
	/*
	 * The constructor  "ACProductPage" does initialize the webdriver and
	 * action class objects, initialize the PageFactory for Air Conditioner
	 * module web page
	 * 
	 * @param driver - Receives webdriver object
	 */
	public ACProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Returns number of specification of Air Conditioner product
	 * 
	 * @returns integer - Number of specification of Air Conditioner product directly
	 * 
	 * (non-Javadoc)
	 * @see interfacePack.Product#toSendSpecCount()
	 */
	public int toSendSpecCount() {
		return specCount;
	}
	
	/*
	 * Retrieves the label name of required specification based on
	 * received integer parameter
	 * If some of the specification is not found in the web page it's
	 * throws "NoSuchElementException" then it returns "Nil" 
	 * 
	 * @param i - To choose specific label
	 * 
	 * @return String - Value of the specification
	 * 
	 * @throws NoSuchElementException if webelement is found missing in the DOM
	 * 
	 * (non-Javadoc)
	 * @see interfacePack.Product#getDetails(int)
	 */
	public String getDetails(int i) {
		
		try {
			
			if(i==1) return ACName.getText();
			else if(i==2) return ACPrice.getAttribute("content");
			else if(i==3) return ACDiscount.getText();
			else if(i==4) {
				ClickFeatures.click();
				return ACBrand.getText();
			}
			else if(i==5) return ACType.getText();
			else if(i==6) return ACModelCode.getText();
			else if(i==7) return ACCapacity.getText();
			else if(i==8) return ACStarRating.getText();
			else if(i==9) return ACColour.getText();
		}
		catch(NoSuchElementException e) {
		  return "Nil";
		}
		return null;
	}
}
