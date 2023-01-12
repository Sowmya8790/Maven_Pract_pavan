package Tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;

public class LoginTest extends BaseClass{
	
	LoginPage lp;
	
	@Test
	public void loginpositive() throws InterruptedException {
		
		
		Thread.sleep(3000);
		
		lp = new LoginPage(driver);
		lp.credentials("jack_123456", "Sowmya@123");
		String expected_tile = "Free and open-source eCommerce platform. ASP.NET Core based shopping cart. - nopCommerce";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expected_tile);
		//test.log(LogStatus.INFO, "Loginpositive");
	}
	
	@Test
	public void negativetest() {
		
		lp = new LoginPage(driver);
		lp.credentials("jack_123456", "Sowmyasri@123");
		
		String expected_tilee = "Free and open-source eCommerce platform. ASP.NET Core based shopping cart. - nopCommerce";
		String actualTitlee = driver.getTitle();
		
		Assert.assertNotEquals(actualTitlee, expected_tilee);
	//	test.log(LogStatus.INFO, "negativetest");
	}
	
	@Test
	@Parameters({"username","Password"})
	public void parameter(String user,String pass) {
		
		lp = new LoginPage(driver);
		lp.credentials(user, pass);
		
		String expected_tile = "Free and open-source eCommerce platform. ASP.NET Core based shopping cart. - nopCommerce";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expected_tile);
	//	test.log(LogStatus.INFO, "parameter");
		
		
	}
	
	@Test
	public void datadriven() {
		
		/*int rowcount = wsheet.getLastRowNum();
		System.out.println(rowcount);
		int cellcount = row.getLastCellNum();
		System.out.println(cellcount);*/
		
		String username=wsheet.getRow(2).getCell(0).getStringCellValue();
		System.out.println(username);
		String password = wsheet.getRow(2).getCell(1).getStringCellValue();
		System.out.println(password);

		
		lp = new LoginPage(driver);
		lp.credentials(username, password);
		
		String expected_tile = "Free and open-source eCommerce platform. ASP.NET Core based shopping cart. - nopCommerce";
		String actualTitle = driver.getTitle();
		
		String testvalid = wsheet.getRow(2).getCell(2).getStringCellValue();
		System.out.println(test);
		
		//Assert.assertNotEquals(actualTitle, expected_tile);
		Assert.assertEquals(actualTitle, expected_tile);
		
	//	test.log(LogStatus.FAIL, "negativetest");
		
	}
	
	

}
