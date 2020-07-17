package Test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseSetup.Base;



public class Listeners implements ITestListener{
	
	Base b = new Base();
	WebDriver driver=null;
	
	public void onTestStart(ITestResult result) {	
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		/*System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
       WebDriver driver = (WebDriver)context.getAttribute("driver");
    	b.takeScreenShot(result, driver);*/
		
		b.getScreenshot(result.getName());
		
		
		
		
	}

 {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {	
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}

}
