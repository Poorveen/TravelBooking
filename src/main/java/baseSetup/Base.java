package baseSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class Base {
	
public static WebDriver driver;
	public Properties prop;
	
public static String path = System.getProperty("user.dir");
//@BeforeSuite
//public static void beforeSuite() {}

public WebDriver initializerDriver(WebDriver driver) throws IOException {
	//Report.startReport();
	File file =new File( path+"\\src\\main\\java\\resources\\Data.properties");
	FileInputStream fileInput =null;
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	 prop = new Properties();
	try {
		prop.load(fileInput);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	

	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	
	String url=prop.getProperty("URL");
	System.out.println(url);	
	
	if(browserName.equals("chrome"))
	{
		ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
		//System.setProperty("webdriver.chrome.driver",path+"\\resources\\chromedriver.exe");
		driver =new ChromeDriver();
		
	}
	else if(browserName.equals("firefox"))
	{
		FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
		//System.setProperty("webdriver.gecko.driver",path+"\\resources\\geckodriver.exe");
          
	}
	else if(browserName.equals("IE"))
	{
		InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
		//System.setProperty("webdriver.IE.driver",path+"\\resourcess\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	}
	 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
	return driver;
	
	
}
	

public void getScreenshot(String result) {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
	       try {
	    	   org.openqa.selenium.io.FileHandler.copy(scrFile, new File(path+"\\Screenshot\\"+result+"screenshot.png"));
				System.out.println("***Placed screen shot in "+path+"\\Screenshot\\"+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	

	/*
	 * @AfterSuite public static void endOfSetUp() {
	 * 
	 * Report.tearDown(); }
	 */
		
	}




