package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import interfacePack.Product;

/*
 * This Class has all the webelements for each Computer Accessories 
 * product web page and implements Product interface
 * 
 *  @author Saravanan, Arumugam
 */
public class ComAccessoriesProductPage  implements Product {
	
	// "driver" is an instance for WebDriver Class
	WebDriver driver = null;
	
	//"specCount" is a public variable for number of specification count of Computer Accessories product
	public int specCount = 5;
	
	//"CAName" is a public instance for "Name" label
	@FindBy(xpath = "//h1") public WebElement CAName;
	
	//"CAPrice" is a public instance for "Price" label
	@FindBy(xpath = "//meta[@itemprop='price']") public WebElement CAPrice;
	
	//"CADiscount" is a public instance for "Discount label"
	@FindBy(xpath = "//span[@class='pd-saving-percent']") public WebElement CADiscount;
	
	//"ClickFeatures" is a public instance for "Click Features" link
	@FindBy(xpath = "//a[text()='Features']")public WebElement ClickFeatures;
	
	//"CABrand" is a public instance for "Brand Name" label
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")public WebElement CABrand;
	
	//"CAWarranty" is a public instance for "Warranty" label
	@FindBy(xpath = "//table/tbody/tr[5]/td[2]")public WebElement CAWarranty;
	
	/*
	 * The constructor  "ComAccessoriesProductPage" does initialize the webdriver and
	 * action class objects, initialize the PageFactory for Air Conditioner
	 * module web page
	 * 
	 * @param driver - Receives webdriver object
	 */
	public ComAccessoriesProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/*
	 * Returns number of specification of Computer Accessories product
	 * 
	 * @returns integer - Number of specification of Computer Accessories product directly
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
			
			if(i==1) return CAName.getText();
			else if(i==2) return CAPrice.getAttribute("content");
			else if(i==3) return CADiscount.getText();
			else if(i==4) {
				ClickFeatures.click();
				return CABrand.getText();
			}
			else if(i==5) return CAWarranty.getText();
		}
		catch(NoSuchElementException e) {
		  return "Nil";
		}
		return null;
	}

}
