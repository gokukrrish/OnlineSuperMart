package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import interfacePack.Product;

/*
 * This Class has all the webelements for each Washing Machine
 * product web page and implements Product interface
 * 
 *  @author Saravanan, Arumugam
 */
public class WashMachineProductPage implements Product {
	
	// "driver" is an instance for WebDriver Class
	WebDriver driver = null;
	
	//"specCount" is a public variable for number of specification count of Air Conditioner product
	public int specCount = 6;
	
	//"WMName" is a public instance for "Name" label
	@FindBy(xpath = "//h1") public WebElement WMName;
	
	//"WMPrice" is a public instance for "Price" label
	@FindBy(xpath = "//meta[@itemprop='price']") public WebElement WMPrice;
	
	//"WMDiscount" is a public instance for "Discount label"
	@FindBy(xpath = "//span[@class='pd-saving-percent']") public WebElement WMDiscount;
	
	//"ClickFeatures" is a public instance for "Click Features" link
	@FindBy(xpath = "//a[text()='Features']")public WebElement ClickFeatures;
	
	//"WMBrand" is a public instance for "Brand Name" label
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")public WebElement WMBrand;
	
	//"WMColour" is a public insance for "Color" label
	@FindBy(xpath = "//table/tbody/tr[2]/td[2]")public WebElement WMColour;
	
	//"WMCapacity" is a public instance for "Capacity" label
	@FindBy(xpath = "//table/tbody/tr[3]/td[2]") public WebElement WMCapacity;
	
	/*
	 * The constructor  "WashMachineProductPage" does initialize the webdriver and
	 * action class objects, initialize the PageFactory for Washing Machine
	 * module web page
	 * 
	 * @param driver - Receives webdriver object
	 */
	public WashMachineProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Returns number of specification of Washing Machiner product
	 * 
	 * @returns integer - Number of specification of Washing Machine product directly
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
			
			if(i==1) return WMName.getText();
			else if(i==2) return WMPrice.getAttribute("content");
			else if(i==3) return WMDiscount.getText();
			else if(i==4) {
				ClickFeatures.click();
				return WMBrand.getText();
			}
			else if(i==5) return WMColour.getText();
			else if(i==6) return WMCapacity.getText();
		}
		catch(NoSuchElementException e) {
		  return "Nil";
		}
		return null;
	}
}
