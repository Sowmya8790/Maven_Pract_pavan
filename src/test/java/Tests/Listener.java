package Tests;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class Listener extends TestListenerAdapter{

	public void onTestStarted(ITestResult Result) {
		System.out.println("The test started");
	}
	
	public void onTestPassed(ITestResult Result) {
		System.out.println("The test is passed");
	}
	public void onTestFailed(ITestResult Result) {
		System.out.println("the test is failed");
		
	}
	
	public void onTestSkipped(ITestResult Result) {
		System.out.println("The test is skipped");
	}
}
