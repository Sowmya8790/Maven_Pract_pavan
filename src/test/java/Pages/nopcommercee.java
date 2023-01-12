package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.WaitHelper;

public class nopcommercee {
	
	WebDriver driver;
	WaitHelper wait;
	
	public nopcommercee(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
	}
	
	@FindBy(xpath = "//a[text()='View demo']")
	@CacheLookup
	WebElement view_demo;
	
	@FindBy(xpath = "//a[@class='btn admin-button']")
	@CacheLookup
	WebElement Admin;
	
	@FindBy(xpath ="//input[@id='Email']")
	WebElement Admin_mail;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement Admin_pass;
	
	@FindBy(xpath ="//button[@class='button-1 login-button']")
	WebElement login;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']/a")
	@CacheLookup
	WebElement Customer;
	
	@FindBy(xpath ="//a[@href='/Admin/Product/List']")
	@CacheLookup
	WebElement product;
	
	@FindBy(xpath ="//input[@id='SearchProductName']")
	WebElement pname;
	
	@FindBy(xpath="//select[@id='SearchCategoryId']")
	WebElement category;
	
	@FindBy(xpath ="//select[@id='SearchManufacturerId']")
	WebElement manufacture;
	
	@FindBy(xpath = "//select[@id='SearchVendorId']")
	WebElement vendor;
	
	@FindBy(xpath ="SearchWarehouseId")
	WebElement warehouse;
	
	@FindBy(xpath ="//select[@id='SearchProductTypeId']")
	WebElement producttype;
	
	@FindBy(xpath ="//select[@id='SearchPublishedId']")
	WebElement published;
	
	@FindBy(xpath ="//button[@id='search-products']")
	WebElement button;
	
	
	//Actions method
	
	public void m_view_demo() {
		view_demo.click();		
	}

		public void m_Admin() {
			Admin.click();
			
		}

	public void m_Customer() {
		wait.waitforelement(Customer, 30);
		Customer.click();
	}
	
	public void m_product() {
		product.click();
	}
	
	
	public void m_pname(String productname) {
		pname.sendKeys(productname);
	}
	public void m_category(String text) {
		
		Select ad = new Select(category);
		ad.selectByVisibleText(text);
	}
public void m_manufacture(String text) {
		
		Select ad = new Select(manufacture);
		ad.selectByVisibleText(text);
	}

public void m_vendor(String text) {
	
	Select ad = new Select(vendor);
	ad.selectByVisibleText(text);
}
	
	public void m_warehouse(String text) {
		Select ad = new Select(warehouse);
		ad.selectByVisibleText(text);
	}
	public void m_producttype(String text) {
		Select ad = new Select(producttype);
		ad.selectByVisibleText(text);
	}
	public void m_published(String text) {
		Select ad = new Select(published);
		ad.selectByVisibleText(text);
	}
	
	public void m_button() {
		button.click();
	}
	
	public void m_Admin_mail(String email) {
		Admin_mail.clear();
		Admin_mail.sendKeys(email);
	}
	
	public void m_Admin_pass(String pass) {
		Admin_pass.clear();
		Admin_pass.sendKeys(pass);
	}
	
	public void m_login() {
		login.click();
	}
	
	
	
	
	
	
	
}
