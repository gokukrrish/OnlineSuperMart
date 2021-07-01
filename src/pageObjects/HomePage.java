package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
 * This Class has required webelements at the home page of base URL
 * 
 * @author Saravanan, Arumugam
 */
public class HomePage {
	
	//// "driver" is an instance for WebDriver Class
	WebDriver driver;
	
	//"homeApp" is an instance for "Home Appliances" link
	@FindBy(xpath = "//a[normalize-space(text())='Home Appliances']") WebElement homeApp;
	
	//"airCon" is an instance for "Air Conditioner" link
	@FindBy(xpath = "//div/a/span[text() ='Air Conditioner']") WebElement airCon;
	
	//"refrige" is an instance for "Refrigerator" link
	@FindBy(xpath = "//div/a/span[text() ='Refrigerator']")  WebElement refrige;
	
	//"wMachine" is an instance for "Washing Machine" link
	@FindBy(xpath = "//div/a/span[text() ='Washing Machine']")  WebElement wMachine;
	
	//"electronics" is an instance for "Electronics" link
	@FindBy(xpath = "//a[normalize-space(text())='Electronics']")  WebElement electronics;
	
	//"cAccess" is an instance for "Computer Accessories" link
	@FindBy(xpath = "//div/a/span[text() ='Computer Accessories']")  WebElement cAccess;
	
	/*
	 * The constructor  "HomePage" does initialize the webdriver and
	 * action class objects, initialize the PageFactory for HomePage
	 * web page
	 * 
	 * @param driver - Receives webdriver object
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Clicks the corresponding link required based on parameter
	 * received
	 * 
	 * @param flag - To choose specific link for clicking
	 * 
	 * @throws NoSuchElementException if webdriver unable to find the required element
	 */
	public void toClick(int flag) {
		switch(flag) {
			case 1: homeApp.click(); break;
			case 2: airCon.click(); break;
			case 3: refrige.click(); break;
			case 4: wMachine.click(); break;
			case 5: electronics.click(); break;
			case 6: cAccess.click(); break;
		}
	}
}
