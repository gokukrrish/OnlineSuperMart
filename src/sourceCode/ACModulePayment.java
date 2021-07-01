package sourceCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Parameters;

import pageObjects.ACPaymentPage;
import pageObjects.AirConditioner;
import pageObjects.HomePage;
import utilities.ExcelRead;
/*
 * This Class verifies the payment process of specific
 * module in the application.
 * 
 * @author Saravanan, Arumugam
 */
public class ACModulePayment{
	
	/*
	 * "HPObj" is an instance for  HomePage Class,
	 * which is a Page Object class of Home Page of
	 * base URL
	 */
	HomePage HPObj = null;
	
	/*
	 * "ACObjPy" is an instance for  AirConditioner Class,
	 * which is a Page Object class of Home Page of
	 * base URL
	 */
	AirConditioner ACObjPy = null;
	
	// "driver" is an instance for WebDriver Class
	WebDriver driver = null;
	
	/*
	 * "ACPyObj" is an instance for  ACPaymentPage Class,
	 * which is a Page Object class of Home Page of
	 * base URL
	 */
	ACPaymentPage ACPyObj = null;
	
	//Used to send data to corresponding text box in the test page
	int j = 1;
	
	/*
	 * The "setUp", which is before class method is to make
	 * default set up like driver initialization and maximize
	 * browser and initialize the PageFactory for Home page of 
	 * base URL.
	 * 
	 * @throws WebDriverException if WebDriver is unable to find the driver
	 */
	@BeforeClass
	 public void setUp() {
		 System.setProperty("webdriver.chrome.driver","C:\\TestingJar\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 HPObj = new HomePage(driver);
		 PageFactory.initElements(driver,HomePage.class);
	  }
	
	/*
	  * The "billingInfo" is a data provider, which provides 
	  * data for billing information for test method "paymentProcess"
	  * 
	  * @return Object[][] - Consists of billing information
	  */
	 @DataProvider
	 public static Object[][] billingInfo() throws Exception {
		 return ExcelRead.getTableArray();
	 }
	 
	 /*
	  * The "bMtdGnrlMtd", which is before method to loaded the
	  * base URL to the browser
	  * 
	  * @param bURL - Gets the base URL from XML file
	  * 
	  * @throws TimeoutException if driver gets delayed to load base URL
	  */
	 @BeforeMethod
	 @Parameters({"baseURL"})
	 public void bMtdGnrlMtd(String bURL){
		 driver.get(bURL);
	 }
	
	 /*
	  *  The "paymentProcess" is a test method receives the billing
	  *  information from data provider "billingInfo" and send it to
	  *  corresponding text box in the test page.
	  *  
	  *  @param fNme - "First Name" data at the billing information.
	  *  @param lNme - "Last Name" data at the billing information.
	  *  @param addr - "Address" data at the billing information.
	  *  @param city - "city" data at the billing information.
	  *  @param pCode - "Pin Code" data at the billing information.
	  *  @param country - "Country" data at the billing information.
	  *  @param email - "Email" data at the billing information.
	  *  @param phnNo - "Phone Number" data at the billing information.
	  *  
	  *  @throws MethodMatcherException if data provider gives insufficent data
	  */
	 @Test(dataProvider = "billingInfo")
	  public void paymentProcess(String fNme, String lNme, String addr, String city, String pCode, String country, String email, String phnNo){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Payment Process for Air Conditioner");
		SoftAssert sAstObj= new SoftAssert();
		HPObj.toClick(1);
		HPObj.toClick(2);
		ACObjPy = new AirConditioner(driver);
		ACPyObj = new ACPaymentPage(driver);
		for(int i = 0; i < ACObjPy.totalElements(); i++) {
			if(ACObjPy.eachProduct(i)||ACPyObj.forPayment()) {
				System.out.println("No Add to Cart");
				driver.navigate().back();
				continue;
			}
			break;
		}
		ACPyObj.checkoutProcess();
		ACPyObj.sendDetails(j++,fNme);
		ACPyObj.sendDetails(j++,lNme);
		ACPyObj.sendDetails(j++,addr);
		ACPyObj.sendDetails(j++,city);
		ACPyObj.sendDetails(j++,pCode);
		ACPyObj.sendDetails(j++,country);
		ACPyObj.sendDetails(j++,email);
		ACPyObj.sendDetails(j, phnNo);
		ACPyObj.toNext();
		ACPyObj.confirmShipping();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ACPyObj.toNext();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(ACPyObj.toGetCurtURL());
		sAstObj.assertTrue(!"https://www.sathya.in/Checkout/PaymentMethod".equals(ACPyObj.toGetCurtURL()),"Payment Page Reached");
		ACPyObj.toNext();
		sAstObj.assertTrue(!"https://www.sathya.in/Checkout/Confirm".equals(ACPyObj.toGetCurtURL()),"Confirmation Page Reached");
		System.out.println(ACPyObj.toGetCurtURL());
	  }
	
	  /*
	   * The "toCloseBrowser" is a After Class method,
	   * used to close browser
	   */
	@AfterClass
	public void toCloseBrowser() {
		driver.close();
	}
}