package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackupPage {

	By Button_Backup =By.xpath("//div[contains(text(),'Backup')]");
	By Title_Backup =By.xpath("//*[@id='content']/div[2]/div[1]/h3");
	
	
	
WebDriver driver;
	
	public BackupPage(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement Button_Backup() {return driver.findElement(Button_Backup);}
	public WebElement Title_Backup() {return driver.findElement(Title_Backup);}
	
	
}
