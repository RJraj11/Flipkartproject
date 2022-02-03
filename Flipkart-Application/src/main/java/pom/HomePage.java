package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

private WebDriver driver ;
	
	@FindBy ( xpath = "//img[@alt='Travel']")
	private WebElement travel;
	//img[@alt='Beauty, Toys & More']

	
	@FindBy ( xpath = "//div[text()='Logout']")
	private WebElement logout;
	
	
	@FindBy ( xpath = "(//div[@class='exehdJ'])[1]")
	private WebElement logouticon;
	
	@FindBy ( xpath = "//img[@alt='Electronics']")
	private WebElement electronics;

public HomePage (WebDriver driver) { //driver1 = driver = new chromeDriver()
		
		PageFactory.initElements(driver, this);
		this. driver = driver;
		
		
	}
      public void clickontravel () throws InterruptedException {
	  if(travel.isDisplayed()) {
		  travel.click();
		  Thread.sleep(2000);
		  
		  
		  
	  
}
}
    public void clickonelectronics () throws InterruptedException {
    	
    	if(electronics.isDisplayed()) {
    		electronics.click();    		
    		  
    }
    }
    
      
 public void clickonlogouticon () throws InterruptedException {
    	  
	   
	 Actions act = new Actions(driver);
     act.moveToElement(logouticon).build().perform();
     
         
         Thread.sleep(3000);
      
 }

      

 public void clickonlogoutbutton () throws InterruptedException {
    	
    	  
    	  Actions act = new Actions(driver);
          
          
    	  Thread.sleep(2000);
         
          act.moveToElement(logout).click().build().perform();

    	  
    	  
}
}