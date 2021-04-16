package exercise.BasePackage;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import exercise.Utility.ExcelFileReader;

public class BaseInit {
	
	public static Properties storage=null;
	public static WebDriver driver=null;
	public static Logger logs=null;
	public static ExcelFileReader data=null;
	

	public void startUp() throws Exception
	{   
		if(driver==null)
		{
		logs = Logger.getLogger("devpinoyLogger");
		logs.info("Properties file loaded... ");
		storage = new Properties();
		FileInputStream fi = new FileInputStream("./src/exercise/PropertiesData/ObjectStorage.properties");
		storage.load(fi);
		logs.info("Properties file loaded successfully... ");
		logs.info("Browser will be launching....");
		String browserval = storage.getProperty("browser");
		if(browserval.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM WEBDRIVER\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			logs.info("Chrome Browser luanched....");
		}
		else if(browserval.equalsIgnoreCase("firefox"))
		{
			System.setProperty("browser.geckodriver.driver","E:\\SELENIUM WEBDRIVER\\geckodriver-v0.28.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			logs.info("Firefox Browser luanched....");
		}
		else
		{
			System.out.println("Browser Not Found");
			logs.info("Browser not defined....");
		}
		driver.manage().window().maximize();
		logs.info("Browser window is maximized.....");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		logs.info("Timeout defined....");
		driver.manage().deleteAllCookies();
		logs.info("All cockies are deleted....");
		data = new ExcelFileReader("./src/exercise/TestData/TestCases.xlsx");
		logs.info("Object of ExcelFileReader class is created....");
		}
	}
	
	public static WebElement isElementpresent(String propkey)
	{
		try
		{
			if(propkey.contains("xpath"))
			{
				return driver.findElement(By.xpath(storage.getProperty(propkey)));
			}
			else if(propkey.contains("name"))
			{
				return driver.findElement(By.name(storage.getProperty(propkey)));
			}
			else if(propkey.contains("id"))
			{
				return driver.findElement(By.id(storage.getProperty(propkey)));
			}
			else if(propkey.contains("linkText"))
			{
				return driver.findElement(By.linkText(storage.getProperty(propkey)));
			}
			else
			{
				System.out.println("Element not defined");
			}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	

}
