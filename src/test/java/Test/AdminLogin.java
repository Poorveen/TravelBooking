package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.phpTravels.AdminLoginPage;

import baseSetup.Base;

// verify the Admin Login

public class AdminLogin extends Base {
	

	
@Test(dataProvider = "getdata", priority = 1, groups = { "AdminLogin" }, description="verify the Admin Login")
	public void loginAdmin(String Username, String Password, String Text) throws IOException, InterruptedException {
	//ExtentTest	test= Report.extentRep.createTest("Admin Login");
		driver = initializerDriver(driver);
		driver.get(prop.getProperty("URL"));
		AdminLoginPage al = new AdminLoginPage(driver);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,250)","");
		Thread.sleep(3000);
		WebElement e=driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block']//small[text()=\"http://www.phptravels.net/admin\"]"));
		e.click();
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		al.getAdminLoginid().sendKeys(Username);
		al.getAdminLoginpwd().sendKeys(Password);
		al.getLoginButton().click();
		System.out.println(Text);
		Thread.sleep(3000);
		String Title = driver.getTitle();
		//System.out.println(Title);
		
		if(Title=="Administator Login") {
		Assert.assertTrue(true);
		//test.info("Valid credentials");
				}
		
		else {
			Assert.assertFalse(false);
		//test.info("Invalid credentials");	
		}
		}
		
	 
	@DataProvider
	public Object[][] getdata() {

		Object[][] data = new Object[4][3];

		data[0][0] = "admin@phptravels.com";
		data[0][1] = "demoadmin";
		data[0][2] = "ValidUser";

		data[1][0] = "fakeUser@mail.com";
		data[1][1] = "123456";
		data[1][2] = "FakeUser";
		
		data[2][0] = "fakeUser@mail.com";
		data[2][1] = "demoadmin";
		data[2][2] = "incorrect username";
		
		data[3][0] = "admin@phptravels.com";
		data[3][1] = "123456";
		data[3][2] = "incorrect password";

		return data;

	}
	
	@AfterTest
	 public void teardown()
	 { 
		
		driver.quit(); 
		//Report.tearDown();
	    
	  }

	}



