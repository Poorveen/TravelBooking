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
import com.pageObjects.phpTravels.CMSPages_Page;

import baseSetup.Base;

public class CMSPages extends Base {
	
	
	@BeforeTest
	public void initializerDriver() throws IOException, InterruptedException {
			
			driver = initializerDriver(driver);
			driver.get(prop.getProperty("URL"));
		}
		//Verify that CMS tab is accessible to admin
	
		@Test(priority = 2, groups = { "Dashboard" }, description="Verify that CMS tab is accessible to admin")
		public void CMSPage() throws InterruptedException {
			//ExtentTest	test= Report.extentRep.createTest("16_TC_AdminDashboard_04_Verify that CMS tab is accessible to admin");
			
			AdminLoginPage al = new AdminLoginPage(driver);
			CMSPages_Page cms = new CMSPages_Page(driver);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollBy(0,250)","");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]")).click();
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			al.getAdminLoginid().sendKeys(prop.getProperty("usernameadmin"));
			al.getAdminLoginpwd().sendKeys(prop.getProperty("passwordadmin"));
			al.getLoginButton().click();
			cms.Button_CMSpages().click();
			Thread.sleep(3000);
			cms.Title_CMS().getText();
			String cmsTitle =driver.getTitle();
			Assert.assertEquals(cmsTitle, "CMS Management");
			//test.info("CMSPage window get displayed");
}
		@AfterTest
		 public void teardown()
		 { 
			
			driver.quit(); 
			//Report.tearDown();
		    
		  }

}