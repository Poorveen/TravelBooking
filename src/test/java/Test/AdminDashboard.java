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

import baseSetup.Base;

public class AdminDashboard extends Base{
	@BeforeTest
	public void adminLogin() throws IOException, InterruptedException {
		//Report.startReport();
		driver = initializerDriver(driver);
		driver.get(prop.getProperty("URL"));
		AdminLoginPage al = new AdminLoginPage(driver);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]")).click();
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		al.getAdminLoginid().sendKeys(prop.getProperty("usernameadmin"));
		al.getAdminLoginpwd().sendKeys(prop.getProperty("passwordadmin"));
		al.getLoginButton().click();
	}
	

	@Test(priority = 1, groups = { "Dashboard" }, description="Verify that  dashboard get displayed on Admin home page")
	public void Dashboardpage() throws InterruptedException {
		//ExtentTest	test= Report.extentRep.createTest("15_TC_AdminDashboard_03_Verify that  dashboard get displayed on Admin home page");
		
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(300);
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(2));
		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "PHPTRAVELS | Travel Technology Partner");	
		//test.info("Admin  dashboard dispalyed");
		
	}
	
	@AfterTest
	 public void teardown()
	 { 
		
		driver.quit(); 
		//Report.tearDown();
	    
	  }

}
