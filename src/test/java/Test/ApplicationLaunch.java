package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseSetup.Base;

public class ApplicationLaunch extends Base{

	
	@BeforeTest
	public void initializerDriver() throws IOException {
		driver = initializerDriver(driver);
		driver.get(prop.getProperty("URL"));
		

	}
	//Verify that application is launched successfully
	
	
	@Test (priority = 3, groups = { "LandingPage" }, description="01_TC_HomePage_001")
	public void Titlename() throws IOException {
		//ExtentTest	test= Report.extentRep.createTest("01_TC_HomePage_001_'Verify that application is launched successfully'");
		String title = driver.getTitle();
		//System.out.println(title);
		Assert.assertEquals("Demo Script Test drive - PHPTRAVELS", title);
		//test.info("Title");
	}
	
	@AfterTest
	 public void teardown()
	 { 
		
		driver.quit(); 
		//Report.tearDown();
	    
	  }
}
