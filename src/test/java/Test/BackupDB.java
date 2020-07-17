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
import com.pageObjects.phpTravels.BackupPage;

import baseSetup.Base;

public class BackupDB extends Base {
	
	@BeforeTest
	public void initializerDriver() throws IOException, InterruptedException {
			
			driver = initializerDriver(driver);
			driver.get(prop.getProperty("URL"));
		}
	
	//Verify Backup tab is accesible to admin	
		
	
		@Test (priority = 1, groups = { "Admin Dashboard" }, description="Verify Backup tab is accesible to admin	")
		public void BackupTab() throws InterruptedException {
			//ExtentTest	test= Report.extentRep.createTest("19_TC_AdminDashboard_07_Verify Backup tab is accesible to admin");
			AdminLoginPage al = new AdminLoginPage(driver);
			BackupPage bp= new BackupPage(driver);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollBy(0,250)","");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]")).click();
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browserTabs.get(1));
			al.getAdminLoginid().sendKeys(prop.getProperty("usernameadmin"));
			al.getAdminLoginpwd().sendKeys(prop.getProperty("passwordadmin"));
			al.getLoginButton().click();
			bp.Button_Backup().click();
			Thread.sleep(3000);
			String titleBackupDB=bp.Title_Backup().getText();
			System.out.println(titleBackupDB);
			Assert.assertEquals(titleBackupDB, "BACKUP DATABASE");
			//test.info("Backup window get displayed");
			
}
		@AfterTest
		 public void teardown()
		 { 
			
			driver.quit(); 
			//Report.tearDown();
		    
		  }

}
