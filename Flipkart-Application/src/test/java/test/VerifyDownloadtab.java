package test;

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

import base.Base;
import pom.HomePage;
import pom.LoginPage;
import pom.MorePage;

public class VerifyDownloadtab extends Base {


	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private MorePage morePage;
	private SoftAssert softAssert;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser() {


		System.out.println("launchBrowser");
		
         
         String browser= "chrome";
         if(browser.equals("chrome"))
         {
        driver =openChromeBrowser();  
     	}
	else
	   {
        driver =  openFirefoxBrowser();
       }
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
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
        softAssert =new SoftAssert();  	
    	
    	
    }

    //test case 1
    @Test
    public void  clickonmoreicon() throws InterruptedException {
    	System.out.println("clickonmoreicon");
    	morePage = new MorePage(driver);
    	 Thread.sleep(3000);
    	 morePage.clickonmoreicon();
    	 morePage.clickondownloadbutton();
    	 morePage.clickonplaystore();
    	 Thread.sleep(5000);
   
    	String url =driver.getCurrentUrl();
    
    	
    	Assert.assertEquals(url, "https://www.flipkart.com/mobile-apps?otracker=ch_vn_mobile_apps");
    	
    	String tital = driver.getTitle();
    	softAssert.assertNotEquals(tital, "Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com");
    	softAssert.assertAll();
    	
    	//Assert.assertNotEquals(url,"https://www.flipkart.com/electronics");
    	
    	
    }

 
    
    @AfterClass
    public void ClearObjects() {
		 loginPage = null;
	}
    
    @AfterTest
    public void closeBrowser() {
    	System.out.println("closeBrowser");
    	driver.quit();
    }
}


