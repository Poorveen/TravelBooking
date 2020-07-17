package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {
	
	private WebDriver driver;

	private By AdminLoginid =By.cssSelector("input[name=email]");
	private By AdminLoginpwd =By.cssSelector("input[name=password]");
	private By LoginButton = By.xpath("//span[contains(text(),'Login')]");
	private By HomepageButton = By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[1]");
	private By AdminButton = By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]");

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	


	public AdminLoginPage() {
		// TODO Auto-generated constructor stub
	}




	public WebElement getAdmin_button() {
		return driver.findElement(AdminButton);
	}


	public WebElement getHomepagebutton() {
		
		return driver.findElement(HomepageButton);
	}

 	
 	public WebElement getAdminLoginid() {
		return driver.findElement(AdminLoginid);
	}

	public WebElement getAdminLoginpwd() {
		
		return driver.findElement(AdminLoginpwd);
	}
	public WebElement getLoginButton() {
		
		return driver.findElement(LoginButton);
	}


}