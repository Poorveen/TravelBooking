package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage {
	
	WebDriver driver;
	
	By button_Booking=By.xpath("//button[@class='btn btn-primary btn-block']");
	By title_BookingMgt=By.xpath("//div[@class='panel-heading' and text()='Booking Management']");
	By checkbox_Logs =By.xpath("//input[@class='checkboxcls']");
	By button_Remove =By.xpath("//a[@class='xcrud-action btn btn-danger btn-xcrud']");
	
	
	public BookingPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	public WebElement button_Booking() {return driver.findElement(button_Booking);}
	public WebElement title_BookingMgt() {return driver.findElement(title_BookingMgt);}
	public WebElement checkbox_Logs() {return driver.findElement(checkbox_Logs);}
	public WebElement button_Remove() {return driver.findElement(button_Remove);}
}
