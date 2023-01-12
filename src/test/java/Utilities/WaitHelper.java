package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public  void waitforelement(WebElement element, long timesecond) {
		WebDriverWait wait = new WebDriverWait(driver, timesecond);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}

	
		
	}

