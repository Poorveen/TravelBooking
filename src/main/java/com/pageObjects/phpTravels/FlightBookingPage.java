package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightBookingPage {

	By flight_Button = By.xpath("//a[contains(@class,'text-center flights')]");
	By oneWay =     By.xpath("//label[contains(text(),'One Way')]");
	By selectTravelClass=By.xpath("//span[contains(text(),'Economy')]");
	By roundTrip =  By.xpath("//label[contains(text(),'Round Trip')]");
	//(//div[@class='row  mb-10 row-reverse align-items-start row-return']/div/div/div[1])[1]
	By travelFirst =  By.xpath("//li[contains(text(),'First')]");
	By travelEconomy =  By.xpath("//span[contains(text(),'Economy')]");
	By travelBusiness =  By.xpath("//li[contains(text(),'Business')]");
	
	By source =     By.xpath("(//div[@class='select2-container form-control'])[1]");
	By destination =By.cssSelector("#s2id_location_to");
			//.xpath("(//div[@class='select2-container form-control'])[2]");
	By enterSource=By.xpath("//input[@id='location_from']")	;
	By enterDestination=By.xpath("//input[@id='location_to']");
	By adult=By.xpath("(//div[@class='tab-inner menu-horizontal-content']//button[contains(text(),'+')])[3]");
	By child=By.xpath("(//div[@class='tab-inner menu-horizontal-content']//button[contains(text(),'+')])[4]");
	By infant=By.xpath("(//div[@class='tab-inner menu-horizontal-content']//button[contains(text(),'+')])[5]");
	By search_button=By.xpath("//button[@class='btn-primary btn btn-block']");	
	By modifySearch_button=By.xpath("//div[@class='ml-auto']//button");
	By book_button=By.xpath("(//button[text()='Book Now'])[1]");
	By click_Title=By.xpath("//*[@id=\"title\"]");
	
	private WebDriver driver;

	public FlightBookingPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getflight_Button() {return driver.findElement(flight_Button);}
	public WebElement getoneWay() {return driver.findElement(oneWay);}
	public WebElement getroundTrip() {return driver.findElement(roundTrip);}
	public WebElement gettravelFirst() {return driver.findElement(travelFirst);}
	public WebElement gettravelEconomy() {return driver.findElement(travelEconomy);}
	public WebElement gettravelBusiness() {return driver.findElement(travelBusiness);}
	public WebElement getsource() {return driver.findElement(source);}
	public WebElement getdestination() {return driver.findElement(destination);}
	public WebElement getenterdestination() {return driver.findElement(enterDestination);}
	public WebElement getentersource() {return driver.findElement(enterSource);}
	public WebElement getadult() {return driver.findElement(adult);}
	public WebElement getchild() {return driver.findElement(child);}
	public WebElement getinfant() {return driver.findElement(infant);}
	public WebElement getsearch_button() {return driver.findElement(search_button);}
	public WebElement getmodifySearch_button() {return driver.findElement(modifySearch_button);}
	public WebElement getbook_button() {return driver.findElement(book_button);}
	public WebElement click_Title() {return driver.findElement(click_Title);}
	public WebElement selectTravelClass() {return driver.findElement(selectTravelClass);}
}
