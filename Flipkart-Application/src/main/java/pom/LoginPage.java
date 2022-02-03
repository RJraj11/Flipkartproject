package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

private WebDriver driver;
	
	@FindBy (xpath = "(//input[@autocomplete='off'])[2]")
	private WebElement userName ;
	
	@FindBy ( xpath = "//input[@type='password']")
	private WebElement password ;
	
	@FindBy ( xpath = "(//button[@type='submit'])[2]")
	private WebElement logInButton;
	
	//@FindBy ( xpath = "//a[text()='Forgotten password?']")
	//private WebElement forgotpassword;
	
	
	
	public LoginPage (WebDriver driver) { //driver1 = driver = new chromeDriver()
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void sendUserName() {
        //String userid = Utility.getStringFromSheet(1,0);
		
		//String pass = Utility.getStringFromSheet(1,1);
		if(userName.isDisplayed()) {
			userName.sendKeys("9561940711");
		}
	}
	
	public void sendpassword() {
		if(password.isDisplayed()) {
			password.sendKeys("9561940711");
	
		}
	}
	public void clickonloginbutton() {
		if(logInButton.isDisplayed()) {
			logInButton.click();
	
		}
	}
	public void loginpageclick() {
		userName.sendKeys("9561940711");
		password.sendKeys("9561940711");
		logInButton.click();
	}	
}