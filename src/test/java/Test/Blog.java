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
import com.pageObjects.phpTravels.BlogPage;

import baseSetup.Base;

public class Blog extends Base {

	

	@BeforeTest
	public void initializerDriver() throws IOException, InterruptedException {
			
			driver = initializerDriver(driver);
			driver.get(prop.getProperty("URL"));
		}
		
		//Verify Blog  is accessible to admin
		
		@Test(priority = 1, groups = { "Dashboard" }, description="Verify Blog  is accessible to admin" )
		public void Blogs() throws InterruptedException {
			
			//ExtentTest	test= Report.extentRep.createTest("17_TC_AdminDashboard_05_'Verify Blog  is accessible to admin");
			AdminLoginPage al = new AdminLoginPage(driver);
			BlogPage bp = new BlogPage(driver);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollBy(0,250)","");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]")).click();
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			al.getAdminLoginid().sendKeys(prop.getProperty("usernameadmin"));
			al.getAdminLoginpwd().sendKeys(prop.getProperty("passwordadmin"));
			al.getLoginButton().click();
			bp.Button_Blog().click();
			Thread.sleep(3000);
			String titleBlog=bp.Title_Blog().getText();
			//System.out.println(titleBlog);
			Assert.assertEquals(titleBlog, "BLOG MANAGEMENT");
			//test.info("Blog window get opneded successfully");
			
}
		@AfterTest
		 public void teardown()
		 { 
			
			driver.quit(); 
			//Report.tearDown();
		    
		  }

}