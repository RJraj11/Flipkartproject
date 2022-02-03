package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utils.Utility2;
import base.Base;
import pom.HomePage;
import pom.LoginPage;

public class TestNGClass extends Base{
	
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private SoftAssert softAssert;
    private int testID;
    static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("Before Test");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void initializePomClasses() {
        loginPage =new LoginPage(driver);

	}
    @BeforeMethod
    public void loginFlipkart() {
    	System.out.println("loginFlipkart");
    	driver.get("https://www.flipkart.com/");
    	loginPage.loginpageclick();
    	HomePage 	homePage = new 	HomePage(driver);    	
    	softAssert =new SoftAssert();     	
    }

    //test case 1
    @Test
    public void clickontravel() throws InterruptedException {
    	testID = 101;
    	Thread.sleep(3000);
    	System.out.println("travel");
    	 homePage = new HomePage(driver);
    	 Thread.sleep(3000);
    	homePage.clickontravel();
    	String url =driver.getCurrentUrl();
    
    	Assert.assertNotEquals(url, "https://www.flipkart.com/travel");
    	
    	String tital = driver.getTitle();
    	softAssert.assertNotEquals(tital, " and More Online at Flipkart.com");
    	softAssert.assertAll();
    	
    	
    	//Assert.assertNotEquals(url,"https://www.flipkart.com/electronics");
    	
    	
    }

  //test case 2
    @Test
    public void clickonelectronics() throws InterruptedException {
    	testID=102;
    	Thread.sleep(3000);
    	System.out.println("clickonoelectronics");
    	 homePage = new HomePage(driver);
    	 Thread.sleep(3000);
    	homePage.clickonelectronics();
    	String url =driver.getCurrentUrl();
    	
       Assert.assertNotEquals(url,"https://www.flipkart.com");
       Assert.assertNotEquals(url, "https://www.flipkart.com/travel");
   	
   	String tital = driver.getTitle();
   	softAssert.assertNotEquals(tital, " and More Online at Flipkart.com");
	softAssert.assertAll();
    }
    
    @AfterMethod
    public void clickonlogoutbutton() throws InterruptedException, IOException {
    	Thread.sleep(3000);
    Utility2.saveScreenshot(driver, testID);
    System.out.println("Take saveScreenshot");
    	homePage.clickonlogouticon();
    	Thread.sleep(3000);
    	homePage.clickonlogoutbutton();
    	 
    	System.out.println("logOutFlipkart");
        Thread.sleep(3000);   	
    }
    
    @AfterClass
	public void ClearObjects() {
        loginPage =null;
    }
    	
    @AfterTest
    public void closeBrowser() {
    	System.out.println("closeBrowser");
    	driver.quit();
    	driver=null;
    	System.gc();
    }
}

