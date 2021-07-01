package pageObjects;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import interfacePack.Commodity;

/*
 *This Class has all the page objects in Washing Machine module
 *and implements Commodity interface
 *
 *@author Saravanan, Arumugam
 */
public class WashMachine implements Commodity {
	
	// "driver" is an instance for WebDriver Class
	WebDriver driver = null;
	
	//"builder" is an instance for Actions Class
	Actions builder = null; 
	
	//"sltPerPage"  is an instance for dropdown box webelement
	@FindBy(xpath = "//select[@name='artlist-action-pagesize']") WebElement sltPerPage;
	
	//"elements"  is an instance for list of webelements in Washing Machine module.
	@FindBys(@FindBy(xpath = "//h3/a/span")) public List<WebElement> elements;
	
	/*
	 * The constructor  "Washing Machine" does initialize the webdriver and
	 * action class objects, initialize the PageFactory for Washing Machine
	 * module web page
	 * 
	 * @param driver - Receives webdriver object
	 */
	public WashMachine(WebDriver driver) {
		this.driver = driver;
		builder = new Actions(driver);
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/*
	 * The "toSelect" method to select value "120" in drop dwon box
	 * at the Washing Machine module web page
	 * 
	 * (non-Javadoc)
	 * @see interfacePack.Commodity#toSelect()
	 */
	public void toSelect() {
		Select  slt =   new Select(sltPerPage);
		slt.selectByValue("120");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/*
	 * The "toSendList" method used to return list of
	 * web elements in Washing Machine module web page
	 * 
	 * @return elements - list of web elements in Washing Machine module web page
	 * (non-Javadoc)
	 * @see interfacePack.Commodity#toSendList()
	 */
	public List<WebElement> toSendList(){
		return  elements;
	}
	
	/*
	 * Returns total number of webelements in Washing Machine Module
	 * 
	 * @return  - Total Webelements directly
	 * 
	 * (non-Javadoc)
	 * @see interfacePack.Commodity#totalElements()
	 */
	public int totalElements() {
		return elements.size();
	}
	
	/*
	 * Clicks the each Washing Machine Product by using it's xpath and returns
	 * false if webelement of specific Washing Machine Product is clicked else
	 * it returns true if webelement is found missing in the web page DOM.
	 * 
	 * @return boolean - boolean value 
	 * 
	 * @throws NoSuchElementException if webelement is found missing
	 * 
	 * (non-Javadoc)
	 * @see interfacePack.Commodity#eachProduct(int)
	 */
	public boolean eachProduct(int i) {
		String forPass = "//h3/a/span[text()='" + elements.get(i).getText() + "']";
		try {
			builder.moveToElement(driver.findElement(By.xpath(forPass))).click().build().perform();
		}
		catch(NoSuchElementException e) {
			System.out.println("Washing Machine Product Product Skipped");
			return true;
		}
		return false;
	}
}
