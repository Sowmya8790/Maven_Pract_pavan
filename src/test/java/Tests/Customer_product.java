package Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.nopcommercee;
import Utilities.WaitHelper;

public class Customer_product extends BaseClass{
	
	 LoginPage lp;
	 nopcommercee np;
	 
	 
	@Test
	public void product() {
		
		//declaring the instance of the class 1
		
		lp = new LoginPage(driver);
		
		lp.credentials("jack_123456", "Sowmya@123");
		System.out.println(driver.getWindowHandle());
		//declaring the instance of the class 2
		
		np = new nopcommercee(driver);
		
		np.m_view_demo();
		np.m_Admin();
		Set<String> ids = driver.getWindowHandles();
		List<String> winid = new ArrayList(ids);
		
		String parentwin= winid.get(0);
		String childwin = winid.get(1);
		driver.switchTo().window(childwin);
		
		np.m_Admin_mail("admin@yourstore.com");
		np.m_Admin_pass("admin");
		np.m_login();
		np.m_Customer();
		np.m_product();
		np.m_pname("fire-bolt:9067");
		np.m_category("Electronics >> Others");
		np.m_manufacture("Apple");
		np.m_vendor("Vendor 1");
		np.m_warehouse("Warehouse 1 (New York)");
		np.m_producttype("Simple");
		np.m_published("Published only");
		np.m_button();
		
	}

}
