package com.sample.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class customerPage {
	
	
	WebDriver driver;
	
	
	@FindBy (how=How.XPATH,using = ".//*[@id='FirstName']") 
	WebElement FIRST_NAME;
	
	@FindBy (how=How.XPATH,using = ".//*[@id='LastName']") 
	WebElement LAST_NAME;
	
	@FindBy (how=How.XPATH,using = ".//*[@id='Email']")
	WebElement EMAIL;
	
	@FindBy (how=How.XPATH,using =".//input[@value='Save']")
	WebElement SAVE_BTN;
	
	@FindBy (how=How.XPATH,using =".//table//a[text()='Update']")
	WebElement UPDATE_LINK;
	
	@FindBy (how=How.XPATH,using =".//table//a[text()='Remove']")
	WebElement REMOVE_LINK;
	
	@FindBy (how=How.XPATH,using =".//a[text()='New Customer']")
	WebElement NEW_CUSTOMER_BTN;
	
	
	
	public customerPage(WebDriver driver){
		
		
		this.driver = driver;
		
	
		
	}
	
	
	
	//Create New Customer
	
	public void createCustomer() throws InterruptedException{
		
		
		String firstName = "Andres";
		String lastName = "Iniesta";
		String email = "email@g.com";
		
		//Click the customer button after logged in
		 clickCusButton();
		
		//Enter First Name
		 
		 FIRST_NAME.sendKeys(firstName);
		 
		 
	    //Enter Last Name
		 
		 LAST_NAME.sendKeys(lastName);
		
		
        //Enter Email
		 
		 EMAIL.sendKeys(email);
		 
		 
        //Click Save
		 
		 SAVE_BTN.click();
		
		
		Thread.sleep(4000);
		
		
	}
	
	//Update customer information
	public void updateCustomer() throws InterruptedException{
		
		String firstName = "Xavi";
		String lastName = "Hernandez";
		String email = "email@x.com";
		
		
		//Click Update Link
		 UPDATE_LINK.click();
		
		 Thread.sleep(4000);
		
		
		
		
		//Enter First Name
		 FIRST_NAME.clear();
		 FIRST_NAME.sendKeys(firstName);
		 
		 
	    //Enter Last Name
		 LAST_NAME.clear();
		 LAST_NAME.sendKeys(lastName);
		
		
       //Enter Email
		 EMAIL.clear();
		 EMAIL.sendKeys(email);
		 
		 
       //Click Save
		 
		 SAVE_BTN.click();
		
		
		 Thread.sleep(4000);
		
		
		
		
	}
	
	
	public void removeCustomer() throws InterruptedException{
		
		
		
		REMOVE_LINK.click();
		
		
		Thread.sleep(2000);
		
		
		
		
		
	}
	
	
	public void clickCusButton() throws InterruptedException{
		
		
		
		NEW_CUSTOMER_BTN.click();
		
		Thread.sleep(2000);
		
		
		
		
	}
	
	
	
	
	
	
	

}
