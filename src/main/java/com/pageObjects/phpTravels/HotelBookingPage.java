package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	

public class HotelBookingPage {

	By Hotel_Button= By.xpath("(//*[contains(text(),'Hotels')])[1]");
	By Input_Destination=By.xpath("//span[text()='Search by Hotel or City Name']");
	////div[@id='s2id_autogen1']
	By ButtonAdd_Adult=By.xpath("(//span[@class='input-group-btn-vertical']//button[contains(text(),'+')])[1]");
	By ButtonAdd_Infant=By.xpath("(//span[@class='input-group-btn-vertical']//button[contains(text(),'+')])[2]");
	By Button_Search=By.xpath("//*[@class='btn btn-primary btn-block' and contains(text(),'  Search')]");
	By Button_Details=By.xpath("//button[@class='btn btn-primary' and contains(text(),'Details ')]");
	By Button_PriceandDates=By.xpath("//a[@class='anchor btn btn-primary btn-wide mt-5']");
	
	WebDriver driver;
	
	public HotelBookingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement Hotel_Button() {return driver.findElement(Hotel_Button);}
	public WebElement Input_Destination() {return driver.findElement(Input_Destination);}
	public WebElement ButtonAdd_Adult() {return driver.findElement(ButtonAdd_Adult);}
	public WebElement ButtonAdd_Infant() {return driver.findElement(ButtonAdd_Infant);}
	public WebElement Button_Search() {return driver.findElement(Button_Search);}
	public WebElement Button_Details() {return driver.findElement(Button_Details);}
	public WebElement Button_PriceandDates() {return driver.findElement(Button_PriceandDates);}
	
}
