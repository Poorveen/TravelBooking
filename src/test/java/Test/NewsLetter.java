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
import com.pageObjects.phpTravels.NewsLetterPage;

import baseSetup.Base;

//Verify Newsletter  is accessible to admin

public class NewsLetter extends Base {


	@BeforeTest
	public void initializerDriver() throws IOException, InterruptedException {
			
			driver = initializerDriver(driver);
			driver.get(prop.getProperty("URL"));
		}
		
		@Test(priority = 2, groups = { "Dashboard" }, description="Verify that Newsletter tab is accessible to admin")
		public void NewLetterManagement() throws InterruptedException {
			
			//ExtentTest	test= Report.extentRep.createTest("18_TC_AdminDashboard_06_Verify that Newsletter tab is accessible to admin");
			AdminLoginPage al = new AdminLoginPage(driver);
			NewsLetterPage nl= new NewsLetterPage(driver);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollBy(0,250)","");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]")).click();
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			al.getAdminLoginid().sendKeys(prop.getProperty("usernameadmin"));
			al.getAdminLoginpwd().sendKeys(prop.getProperty("passwordadmin"));
			al.getLoginButton().click();
			nl.Button_NewsLetter().click();
			Thread.sleep(3000);
			String titlenewsLetter=nl.Title_NewsLetter().getText();
			System.out.println(titlenewsLetter);
			Assert.assertEquals(titlenewsLetter, "NEWSLETTER MANAGEMENT");
			//test.info("NewLetter window get displayed");
			
}
		@AfterTest
		 public void teardown()
		 { 
			
			driver.quit(); 
			//Report.tearDown();
		    
		  }

}
