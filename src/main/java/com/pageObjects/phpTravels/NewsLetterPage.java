package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsLetterPage {

	By Button_NewsLetter =By.xpath("//div[contains(text(),'Newsletter')]");
	By Title_NewsLetter =By.xpath("//div[@class='panel-heading']");
	
	
	
WebDriver driver;
	
	public NewsLetterPage(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement Button_NewsLetter() {return driver.findElement(Button_NewsLetter);}
	public WebElement Title_NewsLetter() {return driver.findElement(Title_NewsLetter);}
	
}


