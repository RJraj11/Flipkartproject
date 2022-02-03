package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MorePage {
	

private WebDriver driver ;
	
	@FindBy ( xpath = "(//div[@class='exehdJ'])[2]")
	private WebElement More;
	
	@FindBy ( xpath = "//div[text()='Download App']")
	private WebElement Downloadbutton;
	
	@FindBy ( xpath = "//img[@class=\"_3HURxL\"]")
	private WebElement clickonplaystore;
	
	

public MorePage (WebDriver driver) { //driver1 = driver = new chromeDriver()
		
		PageFactory.initElements(driver, this);
		this. driver = driver;
		
}
		public void clickonmoreicon () throws InterruptedException {
	    	  
			   
			 Actions act = new Actions(driver);
		     act.moveToElement(More).build().perform();
		     
		         
		         Thread.sleep(3000);
		      
		 }

		      

		 public void clickondownloadbutton () throws InterruptedException {
		    	
		    	  
		    	  Actions act = new Actions(driver);
		          
		          
		    	  Thread.sleep(2000);
		         
		          act.moveToElement(Downloadbutton).click().build().perform();
}

public void clickonplaystore () throws InterruptedException {
	  if(clickonplaystore.isDisplayed()) {
		  clickonplaystore.click();
		  Thread.sleep(2000);
		  
	  }

		  
	  
}
}