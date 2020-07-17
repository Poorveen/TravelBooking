package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToursPage {

	By Button_Tours=By.xpath("//a[contains(@class,'text-center tours')]");
	By Button_Search=By.xpath("//*[@id='tours']//button[contains(text(),'Search')]");
	By Button_TourSearch=By.xpath("(//div[@class='ml-auto']//button[ contains(text(),'Search')])[2]");



WebDriver driver;
	
	public ToursPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public WebElement Button_Tours() {
		return driver.findElement(Button_Tours);
	}
	public WebElement Button_Search() {
		return driver.findElement(Button_Search);
	}
	public WebElement Button_TourSearch() {
		return driver.findElement(Button_TourSearch);
	}

}