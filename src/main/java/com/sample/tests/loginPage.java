package com.sample.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage {
	
	WebDriver driver;
	
	@FindBy (how=How.XPATH,using =".//*[@id='Username']")  
	WebElement USER_NAME;
	
	@FindBy (how=How.XPATH,using =".//*[@id='Password']") 
	WebElement PASSWORD;
	
	@FindBy (how=How.XPATH,using =".//*[@id='loginForm']//input[@value='Log in']") 
	WebElement LOGIN_BTN;
	
	@FindBy (how=How.XPATH,using = ".//*[@id='loginLink']")
	WebElement LOGIN_LINK;
	

	
	
	
	public loginPage(WebDriver driver) {
		
		this.driver = driver;
		
		
	}
	public void login() throws InterruptedException{
		
		
		
		String userName = "admin";
		String password = "Allion@321";
		
		
		//Click the Login Link in the main page
		 LOGIN_LINK.click();
		 Thread.sleep(3000);
		 
		//Enter User Name
		 USER_NAME.sendKeys(userName);
		 Thread.sleep(1000);
		 
		//Enter Password
		 PASSWORD.sendKeys(password);
		 Thread.sleep(1000);
		 
		//Click Log in Button
		 LOGIN_BTN.click();
		 Thread.sleep(3000);

		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
