package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pageObjects.phpTravels.AdminLoginPage;
import com.pageObjects.phpTravels.HotelBookingPage;
import com.pageObjects.phpTravels.LandingPage1;
import com.relevantcodes.extentreports.ExtentTest;

import baseSetup.Base;


//Verify the user booked a hotel room successfully

public class HotelBookingNew extends Base {

	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void login() throws IOException, InterruptedException {

		driver = initializerDriver(driver);
		driver.get(prop.getProperty("URL"));
		
		AdminLoginPage al = new AdminLoginPage(driver);
		LandingPage1 hp = new LandingPage1(driver);
		
		hp.HomePage_button().click();
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		hp.Myaccount_button().click();
		hp.selectLogin().click();
		hp.Username_input().sendKeys(prop.getProperty("userhomepage"));
		hp.Password_input().sendKeys(prop.getProperty("homepagepwd"));
		hp.Login_button().click();
		/*
		 * String testLogin =driver.getTitle(); softAssert.assertEquals(testLogin,
		 * "Login Successful");
		 */
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,250)","");
		al.getAdmin_button().click();
		List<String> browserTabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs2.get(1));
		al.getAdminLoginid().sendKeys(prop.getProperty("usernameadmin"));
		al.getAdminLoginpwd().sendKeys(prop.getProperty("passwordadmin"));
		al.getLoginButton().click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		softAssert.assertAll();
	}

	@Test(priority = 1, groups = { "HotelBooking" },description="Verify the user booked a hotel room successfully")
	public void HotelBooking() throws InterruptedException { 
		
		//ExtentTest	test= Report.extentRep.createTest("12_TC_HotelBooking_01_Verify the user booked a hotel room successfully");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(2));
		HotelBookingPage hb = new HotelBookingPage(driver);

		hb.Hotel_Button().click();
		WebElement e = driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(e);
		actions.click();
		actions.sendKeys("Delhi");
		Thread.sleep(3000);
		actions.build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//*[@class='select2-result-label']//span")));
		actions.click();
		actions.build().perform();
		Thread.sleep(3000);
		
		js.executeScript("document.getElementById('checkin').removeAttribute('readonly',0);");
		WebElement checkinDateBox = driver.findElement(By.id("checkin"));
		checkinDateBox.clear();
		checkinDateBox.sendKeys(prop.getProperty("checkindate"));
		checkinDateBox.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		js.executeScript("document.getElementById('checkout').removeAttribute('readonly',0);");

		WebElement checkoutDateBox = driver.findElement(By.id("checkout"));
		checkoutDateBox.clear();
		checkoutDateBox.sendKeys(prop.getProperty("checkoutdate"));
		checkoutDateBox.sendKeys(Keys.TAB);
		Thread.sleep(3000);

		hb.ButtonAdd_Adult().click();
		hb.ButtonAdd_Infant().click();
		hb.Button_Search().click();
	
		String title = driver.getTitle();
		Assert.assertEquals(title, "Hotels Results");
		
		hb.Button_Details().click();
		hb.Button_PriceandDates().click();
		
		String hotelDetails =driver.getTitle();
		
		Assert.assertEquals(hotelDetails, "Hotel Details"); //dummy  title name for validation 
		//test.info("Room get booked successfully");
		
	}
	@AfterTest
	 public void teardown()
	 { 
		
		driver.quit(); 
		//Report.tearDown();
	    
	  }
	}
	
	
