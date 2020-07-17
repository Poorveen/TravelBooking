package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pageObjects.phpTravels.AdminLoginPage;
import com.pageObjects.phpTravels.FlightBookingPage;
import com.pageObjects.phpTravels.LandingPage1;

import baseSetup.Base;

//Verify that user booked a fight ticket for one way

public class OnewayFlightBooking extends Base {

	SoftAssert softAssert = new SoftAssert();
	//ExtentTest test;
	//ExtentReports extent;
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
		Thread.sleep(3000);
		al.getAdmin_button().click();
		List<String> browserTabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs2.get(1));
		al.getAdminLoginid().sendKeys(prop.getProperty("usernameadmin"));
		al.getAdminLoginpwd().sendKeys(prop.getProperty("passwordadmin"));
		al.getLoginButton().click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		softAssert.assertAll();
	}

	@Test (priority = 1, groups = { "FlightBooking" }, description="Verify that user booked a fight ticket for one way")
	public void FlightBookingOneWay() throws InterruptedException {

	
		//ExtentTest	test= Report.extentRep.createTest("10_TC_FBM_02_Verify that user booked a fight ticket for one way");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		FlightBookingPage fb = new FlightBookingPage(driver);
		//test.info("item clicked");
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(2));
		
		fb.getflight_Button().click();
		//test.info("flight button get clicked");
		fb.getoneWay().click();
		fb.selectTravelClass().click();

		String travelclass = prop.getProperty("traveltype");

		if (travelclass.equals("First")) {
			fb.gettravelFirst().click();
		} else if (travelclass.equals("Business")) {
			fb.gettravelBusiness().click();
		} else if (travelclass.equals("Economy")) {
			fb.gettravelEconomy().click();
		}
		//test.info("Tavel type is selected");
		fb.getsource().click();
		fb.getentersource().sendKeys(prop.getProperty("source"));
		Thread.sleep(3000);
		fb.getentersource().sendKeys(Keys.TAB);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#s2id_location_to")));
		fb.getdestination().click();
		fb.getenterdestination().sendKeys(prop.getProperty("destination"));
		Thread.sleep(3000);
		fb.getenterdestination().sendKeys(Keys.TAB);
		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('FlightsDateStart').removeAttribute('readonly',0);");

		WebElement fromDateBox = driver.findElement(By.id("FlightsDateStart"));
		fromDateBox.clear();
		fromDateBox.sendKeys(prop.getProperty("departuredate"));
		fromDateBox.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		// fb.getadult().click();
		// fb.getchild().click();
		// fb.getinfant().click();
		fb.getsearch_button().click();
		//test.info("Searched button get clicked");

		// Select flight
		Boolean isPresent = driver.findElements(By.xpath("//div[@class='lc-pr43nb e903lsu2 lc-1184gse-enter-done']"))
				.size() > 0;

		if (isPresent == true) {
			driver.switchTo().frame(0);

			try {
				driver.findElement(By.xpath("//button[@aria-label='Minimize window']")).click();
			} catch (Exception e1) {
				driver.findElement(By.xpath("//button[@aria-label='Hide greeting']")).click();
				e1.getMessage();
			} finally {
				driver.getTitle();
			}
		}
		driver.switchTo().defaultContent();

		String mod = fb.getmodifySearch_button().getText();
		Assert.assertEquals(mod, "MODIFY SEARCH");
		fb.getbook_button().click();
		//String checkout = driver.getTitle();
		//Assert.assertEquals(checkout, "Booking");

		// Billing Address
		Select drpTitle = new Select(driver.findElement(By.xpath("//*[@id='title']")));
		drpTitle.selectByVisibleText("Mrs.");
		driver.findElement(By.xpath("(//*[@id='name'])[1]")).sendKeys(prop.getProperty("Name"));
		driver.findElement(By.xpath("(//*[@id='surname'])[1]")).sendKeys(prop.getProperty("Surname"));
		driver.findElement(By.xpath("(//*[@id='email'])[1]")).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.xpath("(//*[@id='phone'])[1]")).sendKeys(prop.getProperty("phone"));
		driver.findElement(By.xpath("(//*[@id='birthday'])[1]")).sendKeys(prop.getProperty("birthdate"));
		driver.findElement(By.xpath("(//*[@id='cardno'])[1]")).sendKeys(prop.getProperty("passportno"));
		driver.findElement(By.xpath("(//*[@id='expiration'])[1]")).sendKeys(prop.getProperty("expirationdate"));
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//a[@class='select2-choice']")).click();
		driver.findElement(By.xpath("//a[@class='select2-choice']")).sendKeys(prop.getProperty("nationality"));
		driver.findElement(By.xpath("//a[@class='select2-choice']")).sendKeys(Keys.TAB);
		js.executeScript("window.scrollBy(0,300)", "");

		// Payments
		Select drpCreditcard = new Select(driver.findElement(By.xpath("//*[@id='cardtype']")));
		drpCreditcard.selectByVisibleText("Visa");
		driver.findElement(By.xpath("//*[@id='card-number']")).sendKeys(prop.getProperty("cardnumber"));

		Select drpExpDate = new Select(driver.findElement(By.xpath("//*[@id='expiry-month']")));
		drpExpDate.selectByVisibleText("Feb (02)");

		Select drpExpYear = new Select(driver.findElement(By.xpath("//*[@id='expiry-year']")));
		drpExpYear.selectByVisibleText("2022");

		driver.findElement(By.xpath("//*[@id='cvv']")).sendKeys(prop.getProperty("cvv"));

		js.executeScript("window.scrollBy(0,400)", "");

		WebElement checkBoxAcceptTerm = driver
				.findElement(By.xpath("//div[@class='custom-control custom-checkbox form-group acceptterm']"));

		checkBoxAcceptTerm.click();

		driver.findElement(By.cssSelector("#confirmBooking")).click();

		String bookingSuccessful = driver.getTitle();

		Assert.assertEquals(bookingSuccessful, "Booking Successful"); // dummy page title name for validation */
		
		//test.info("Tickets get booked successfully");

	}
	
	@AfterTest
	 public void teardown()
	 { 
		
		driver.quit(); 
		//Report.tearDown();
	    
	  }

}
