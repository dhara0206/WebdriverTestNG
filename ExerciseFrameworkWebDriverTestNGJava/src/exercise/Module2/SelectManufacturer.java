package exercise.Module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import exercise.BasePackage.BaseInit;
import exercise.Utility.myLibrary;

public class SelectManufacturer extends BaseInit {
	
	@BeforeTest
	public void SetUp() throws Exception
	{
		startUp();
	}
	@Test
	public void testSelectManufacturer() throws InterruptedException
	{
		driver.get(storage.getProperty("url"));
		
		//myLibrary.signIn("dharagujarati0206@gmail.com","dhara123");
		
		WebElement manufacturer =isElementpresent("dd_manufacturers_name");
		
		List<WebElement> manuvalues = manufacturer.findElements(By.tagName("option"));
		
		for(int i=0;i<manuvalues.size();i++)
		{
			String manutext = manuvalues.get(i).getText();
			
			if(manutext.equalsIgnoreCase("Lenovo"))
			{
				manuvalues.get(i).click();
				logs.info("Title of the WebPage:-" + driver.getTitle());
				break;
		
			}
		}
	}
	@AfterTest
	public void closebrowse()
	{
		driver.close();
	}

}
