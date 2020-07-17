package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.phpTravels.AdminLoginPage;
import com.pageObjects.phpTravels.BookingPage;

import baseSetup.Base;

public class Booking extends Base {

	@BeforeTest
	public void initializerDriver() throws IOException, InterruptedException {
			
			driver = initializerDriver(driver);
			driver.get(prop.getProperty("URL"));
		}
	
	
		
		
		@Test(priority = 1, groups = { "Dashboard" }, description="Verify that booking tab is accessible to admin")
		public void booking() throws InterruptedException {
			
			//ExtentTest	test= Report.extentRep.createTest("15_TC_AdminDashboard_03_Verify that booking tab is accessible to admin");
			AdminLoginPage al = new AdminLoginPage(driver);
			BookingPage bp = new BookingPage(driver);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollBy(0,250)","");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]")).click();
			//test.info("Booking Management window get clicked sucessfully");
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			al.getAdminLoginid().sendKeys(prop.getProperty("usernameadmin"));
			al.getAdminLoginpwd().sendKeys(prop.getProperty("passwordadmin"));
			al.getLoginButton().click();
			bp.button_Booking().click();
			String booking =bp.title_BookingMgt().getText();
			Assert.assertEquals(booking, "BOOKING MANAGEMENT");	
			//test.info("Booking Management window get opened sucessfully");
		}
		@AfterTest
		 public void teardown()
		 { 
			driver.quit(); 
			//Report.tearDown();
		    
		  }
}
