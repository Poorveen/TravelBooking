package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuickBookPage {
	


	By Button_QuickBooking=By.xpath("//button[@class='btn btn-danger btn-block']");
	By Dropdown_QuickBooking=By.xpath("//select[contains(@id,'servicetype')]");
	By Button_Next=By.xpath("//button[text()='Next']");
	
	WebDriver driver;
	
	public QuickBookPage(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement Button_QuickBooking() {return driver.findElement(Button_QuickBooking);}
	public WebElement Dropdown_QuickBooking() {return driver.findElement(Dropdown_QuickBooking);}
	public WebElement Button_Next() {return driver.findElement(Button_Next);}
}


