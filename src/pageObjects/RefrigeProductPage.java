package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import interfacePack.Product;

/*
 * This Class has all the webelements for each Refrigerator
 * product web page and implements Product interface
 * 
 *  @author Saravanan, Arumugam
 */
public class RefrigeProductPage implements Product {
	
	// "driver" is an instance for WebDriver Class
	WebDriver driver = null;
	
	//"specCount" is a public variable for number of specification count of Refrigerator product 
	public int specCount = 9;
	
	//"RFName" is a public instance for "Name" label
	@FindBy(xpath = "//h1") public WebElement RFName;
	
	//"RFPrice" is a public instance for "Price" label
	@FindBy(xpath = "//meta[@itemprop='price']") public WebElement RFPrice;
	
	//"RFDiscount" is a public instance for "Discount label"
	@FindBy(xpath = "//span[@class='pd-saving-percent']") public WebElement RFDiscount;
	
	//"ClickFeatures" is a public instance for "Click Features" link
	@FindBy(xpath = "//a[text()='Features']")public WebElement ClickFeatures;
	
	//"RFBrand" is a public instance for "Brand Name" label
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")public WebElement RFBrand;
	
	//"RFType" is a public instance for "Type" label
	@FindBy(xpath = "//table/tbody/tr[2]/td[2]")public WebElement RFType;
	
	//"RFColour" is a public instance for "Colour" label
	@FindBy(xpath = "//table/tbody/tr[3]/td[2]") public WebElement RFColour;
	
	//"RFStarRating" is a public instance for "Star Rating" label
	@FindBy(xpath = "//table/tbody/tr[4]/td[2]")public WebElement RFStarRating;
	
	//"RFCapacity" is a public instance for "Capacity" label
	@FindBy(xpath = "//table/tbody/tr[5]/td[2]")public  WebElement RFCapacity;
	
	//"RFWeight" is a public instance for "Weight" label
	@FindBy(xpath = "//table/tbody/tr[10]/td[2]") public WebElement RFWeight;
	
	/*
	 * The constructor  "RefrigeProductPage" does initialize the webdriver and
	 * action class objects, initialize the PageFactory for Refrigerator
	 * module web page
	 * 
	 * @param driver - Receives webdriver object
	 */
	public RefrigeProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Returns number of specification of Refrigerator product
	 * 
	 * @returns integer - Number of specification of Refrigerator product directly
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
			
			if(i==1) return RFName.getText();
			else if(i==2) return RFPrice.getAttribute("content");
			else if(i==3) return RFDiscount.getText();
			else if(i==4) {
				ClickFeatures.click();
				return RFBrand.getText();
			}
			else if(i==5) return RFType.getText();
			else if(i==6) return RFColour.getText();
			else if(i==7) return RFStarRating.getText();
			else if(i==8) return RFCapacity.getText();
			else if(i==9) return RFWeight.getText();
		}
		catch(NoSuchElementException e) {
		  return "Nil";
		}
		return null;
	}

}
