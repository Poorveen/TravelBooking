package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage1 {

By click_Title=By.xpath("//*[@id='title']");
By HomePage_button=By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[1]");
By Myaccount_button =By.xpath("//*[@class='btn btn-text-inherit btn-interactive']//i");
By selectLogin=By.xpath("//*[@href='https://www.phptravels.net/login']");
By Username_input=By.xpath("//input[@name='username']");
By Password_input=By.xpath("//input[@name='password']");
By Login_button=By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']");


WebDriver driver;

	public LandingPage1(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement click_Title() {return driver.findElement(click_Title);}
	public WebElement HomePage_button() {return driver.findElement(HomePage_button);}
	public WebElement Myaccount_button() {return driver.findElement(Myaccount_button);}
	public WebElement selectLogin() {return driver.findElement(selectLogin);}
	public WebElement Username_input() {return driver.findElement(Username_input);}
	public WebElement Password_input() {return driver.findElement(Password_input);}
	public WebElement Login_button() {return driver.findElement(Login_button);}
	
	
}
