package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BaseClass {
	
	public static WebDriver driver;
	
	XSSFWorkbook wbook;
	XSSFSheet wsheet;
	XSSFRow row; 
	XSSFCell cell;
//	ExtenthtmlReporter reportor;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void testb() throws IOException {
		
		FileInputStream fis = new FileInputStream("Maven_Practisenew.xlsx");//location of file
		wbook = new XSSFWorkbook(fis);
		wsheet = wbook.getSheet("Sheet1");
		
		report = new ExtentReports(".//ExtentReports/Reports.html"); // location to save
	}
	
	@AfterTest
	public void closetest() throws IOException {
		
		wbook.close();
		report.flush();
		report.close();
	}
	
	
	@BeforeMethod
	public void setup(Method method) {
		
		test = report.startTest(method.getName());
		System.setProperty("WebDriver.chrome.driver", "Chromedriver.exe");
		 driver = new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en/login?returnUrl=%2Fen");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
		
	}
	
	@AfterMethod
	public void TearDown(ITestResult Result) throws IOException {
		if(Result.getStatus()==ITestResult.FAILURE) {
			
			test.log(LogStatus.FAIL, Result.getName()); // gives name of the method which is failed
			test.log(LogStatus.FAIL, Result.getThrowable()); // wich gives the failed logs in Exttent report.
			
			String screenshotpath = BaseClass.getSceenshot(driver, Result.getName());
			
			test.addScreenCapture(screenshotpath);
			
			
		}
		else if(Result.getStatus()==ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, Result.getName());
		}
		else
		{
			test.log(LogStatus.PASS, Result.getName());
		}
		report.endTest(test);
		driver.close();
	}
	
	public static String getSceenshot(WebDriver driver, String Screenshotname) throws IOException {
		
		String date = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot tsobj = (TakesScreenshot) driver;
		File src = tsobj.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/ScreenShots/" + Screenshotname + date + ".png";
		
		File finaldestination = new File(destination);
		FileUtils.copyFile(src, finaldestination);
		return destination;
		
	
	}


}
