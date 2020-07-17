package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pageObjects.phpTravels.LandingPage1;

import baseSetup.Base;

public class HomeLogin extends Base {
	

	
	//Verify that user login to home page
	SoftAssert softAssert = new SoftAssert();
	@Test(priority = 1, groups = { "HomePage" }, description="Verify that user login to home page")
	public void loginHomepage() throws IOException, InterruptedException {
		
		//ExtentTest	test= Report.extentRep.createTest("TC_HomePage_05_Verify that Administrator Back-End Button is working");
		driver = initializerDriver(driver);
		driver.get(prop.getProperty("URL"));
		LandingPage1 hp = new LandingPage1(driver);
		hp.HomePage_button().click();
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		hp.Myaccount_button().click();
		//logger.info("My account is clicked");
		hp.selectLogin().click();
		hp.Username_input().sendKeys(prop.getProperty("userhomepage"));
		hp.Password_input().sendKeys(prop.getProperty("homepagepwd"));
		hp.Login_button().click();
		String testLogin =driver.getTitle();
		softAssert.assertEquals(testLogin, "Login Successful");
		softAssert.assertAll();
		//test.info("Login to home successfully");
	}
	
	@AfterTest
	 public void teardown()
	 { 
		
		driver.quit(); 
		//Report.tearDown();
	    
	  }
}
