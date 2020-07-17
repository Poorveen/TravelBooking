package com.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaunchPage {

	WebDriver driver;

	By HomepageButton = By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[1]");
	By AdminButton = By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]");

	public LaunchPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAdminButton() {
		return driver.findElement(AdminButton);
	}

	public WebElement getHomepagebutton() {
		return driver.findElement(HomepageButton);
	}

}
