 package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.phpTravels.LaunchPage;

import baseSetup.Base;

public class ApplicationLandingPage extends Base {

	

	@BeforeTest
	public void initializerDriver() throws IOException {
		driver = initializerDriver(driver);
		driver.get(prop.getProperty("URL"));
		

	}
	
	// Verify the title of the page
	@Test (priority = 3, groups = { "LandingPage" }, description="02_TC_HomePage_002")
	public void Titlename() throws IOException {
		//ExtentTest	test= Report.extentRep.createTest("02_TC_HomePage_002_'Verify the title of the page'");
		String title = driver.getTitle();
		//System.out.println(title);
		Assert.assertEquals("Demo Script Test drive - PHPTRAVELS", title);
		//test.info("Title");
	}
	
	//Verify that Homepage Front-End Button Button is working

	@Test(priority = 2, groups = { "LandingPage" }, description="03_TC_HomePage_003")
	public void homePage() throws InterruptedException {
		//ExtentTest	test= Report.extentRep.createTest("03_TC_HomePage_003_'Verify that Homepage Front-End Button is working'");
		LaunchPage lp = new LaunchPage(driver);
		lp.getHomepagebutton().click();
		Thread.sleep(3000);
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		String title = driver.getTitle();
		Assert.assertEquals(title,"PHPTRAVELS | Travel Technology Partner");
		driver.switchTo().window(browserTabs.get(0));
		//test.info("Front-End Button is clicked");

	}
	
		//Verify that Administrator Back-End Button is working
	
	@Test(dependsOnMethods = { "homePage" },priority = 1, groups = { "LandingPage" },description= "04_TC_HomePage_04")
	public void Adminpage() throws InterruptedException {
		//ExtentTest	test= Report.extentRep.createTest("04_TC_HomePage_04_'Verify that Administrator Back-End Button is working");
		LaunchPage lp = new LaunchPage(driver);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(3000);
		lp.getAdminButton().click();
		
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(2));
		String title = driver.getTitle();
		//System.out.println("title=" + title);
		Assert.assertEquals(title,"Administator Login");
		driver.switchTo().window(browserTabs.get(0));
		//test.info("Administrator Back-End Button is clicked");

	}

	@AfterTest
	 public void teardown()
	 { 
		
		driver.quit(); 
		//Report.tearDown();
	    
	  }

}
