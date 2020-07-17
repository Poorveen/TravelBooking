package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CMSPages_Page {

	By Button_CMSpages =By.xpath("//button[@class='btn btn-info btn-block']");
	By Title_CMS =By.xpath("//div[@class='panel-heading']");
	
	
WebDriver driver;
	
	public CMSPages_Page(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement Button_CMSpages() {return driver.findElement(Button_CMSpages);}
	public WebElement Title_CMS() {return driver.findElement(Title_CMS);}
}
