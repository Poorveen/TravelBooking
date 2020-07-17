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
import com.pageObjects.phpTravels.QuickBookPage;

import baseSetup.Base;

public class QuickBook extends Base {


	@BeforeTest
public void initializerDriver() throws IOException, InterruptedException {
		
		driver = initializerDriver(driver);
		driver.get(prop.getProperty("URL"));
	}
	
	@Test(priority = 1, groups = { "Dashboard" },description="Verify that Quick book tab is accessible to admin")
	
	
	public void quickbook() throws InterruptedException {
		
		
		//ExtentTest	test= Report.extentRep.createTest("14_TC_AdminDashboard_02_Verify that Quick book tab is accessible to admin");
		AdminLoginPage al = new AdminLoginPage(driver);
		QuickBookPage qb = new QuickBookPage(driver);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]")).click();
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		al.getAdminLoginid().sendKeys(prop.getProperty("usernameadmin"));
		al.getAdminLoginpwd().sendKeys(prop.getProperty("passwordadmin"));
		al.getLoginButton().click();
		qb.Button_QuickBooking().click();
		qb.Dropdown_QuickBooking().click();
		//test.info("quick booking clicked");
		qb.Button_Next().click();
		Thread.sleep(3000);
		String pageTitle=driver.getTitle();
		System.out.println("pageTitle="+pageTitle);
		//test.info("quick booking completed");
		Assert.assertEquals(pageTitle, "Dashboard");
		//test.info("quick booking completed");
		
		
		
	}
	@AfterTest
	 public void teardown()
	 { 
		
		driver.quit(); 
		//Report.tearDown();
	    
	  }
}
