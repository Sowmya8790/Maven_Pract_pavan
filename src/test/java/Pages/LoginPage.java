package Pages;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;



public class LoginPage {
	
	public static WebDriver driver;
	WaitHelper wait;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
	}
	
	@FindBy(xpath = "//input[@id='Username']")
	@CacheLookup
	WebElement user;
	
	@FindBy(xpath = "//input[@id='Password']")
	@CacheLookup
	WebElement pass;
	
	@FindBy(xpath = "//div[@class='inputs reversed']//following::div/input")
	@CacheLookup
	WebElement login;
	
	//Action methods
	
	public void credentials(String name, String password) {
		
		
		wait.waitforelement(user, 30);
		wait.waitforelement(pass, 30);
		wait.waitforelement(login, 30);
		user.sendKeys(name);
		pass.sendKeys(password);
		login.click();
	
	}
	
	

}
