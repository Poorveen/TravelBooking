package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {

	By Button_Blog =By.xpath("//div[contains(text(),'Blog')]");
	By Title_Blog =By.xpath("//div[@class='panel-heading']");
	By Click_Dashboard=By.xpath("//strong[contains(text(),'Dashboard')]");
	
	
WebDriver driver;
	
	public BlogPage(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement Button_Blog() {return driver.findElement(Button_Blog);}
	public WebElement Title_Blog() {return driver.findElement(Title_Blog);}
	public WebElement Click_Dashboard() {return driver.findElement(Click_Dashboard);}
}

	

