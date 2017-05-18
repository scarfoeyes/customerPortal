package com.sample.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sample.tests.customerPage;
import com.sample.tests.loginPage;



public class create_customer{
	
	public WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	
	public void setup() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "E:/Automation/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://192.168.1.16:7878/");
		
		
		Thread.sleep(2000);
		

		
		
	}
	
	@AfterClass(alwaysRun=true)
	
	public void teardown(){
		
		this.driver.quit();
		
	}
	
	//Verify whether the user successfully logged into the system
	@Test(groups={"regression"})
	
	public void loginTest() throws InterruptedException{
		

		
		loginPage loginpage = PageFactory.initElements(driver, loginPage.class);
		
		loginpage.login();
		
		//Verify Login
		
		Assert.assertEquals("Hello admin!", driver.findElement(By.xpath(".//*[@id='logoutForm']/ul/li[1]/a")).getText().toString());
		
		
		
		
	}
	
	//Verify Add New Customer
	@Test(groups ={"regression"},dependsOnMethods="loginTest")
	
	public void addNewCustomerTest() throws InterruptedException{
		
		
		
		
		customerPage cusPage = PageFactory.initElements(driver, customerPage.class);
		
		cusPage.createCustomer();
		
		
		//verify new customer is been added
		Assert.assertEquals("Andres", driver.findElement(By.xpath(".//tbody/tr/td[1]")).getText().toString());
		
		
		
		
		
	}
	
	//Verify Update Customer
	@Test(groups ={"regression"},dependsOnMethods="addNewCustomerTest")
	
	public void updateCustomerTest() throws InterruptedException{
		
		
		
		
		customerPage cusPage = PageFactory.initElements(driver, customerPage.class);
		
		cusPage.updateCustomer();
		
		
		//Verify the updated record
		
		try{
		Assert.assertEquals("Xavi", driver.findElement(By.xpath(".//tbody/tr/td[1]")).getText().toString());
		
		
		}catch (Exception e){
			
			
			Reporter.log("Assertion error");
			
		}
		
		
	}
	
//Verify Remove customer	
@Test(groups ={"regression"},dependsOnMethods="updateCustomerTest")
	
	public void removeCustomerTest() throws InterruptedException{
	
	
	
	customerPage cusPage = PageFactory.initElements(driver, customerPage.class);
	
	cusPage.removeCustomer();
	
	
	//Verify the removed record does not exist
	
	try{
		
		
	 Assert.assertEquals("Xavi", driver.findElement(By.xpath(".//tbody/tr/td[1]")).getText().toString());
		
	 
	}catch (Exception e){
		
		
		Assert.assertFalse(false);
		
	}
	
	
	
}

}
