package exercise.Module2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import exercise.BasePackage.BaseInit;
import exercise.Utility.myLibrary;

public class SearchProduct extends BaseInit {
	
	@BeforeTest
	public void SetUp() throws Exception
	{
		startUp();
	}
	@Test(dataProvider = "getproductname")
	public void testSearchProduct(String keyword) throws Exception
	{
		driver.get(storage.getProperty("url"));
		//myLibrary.signIn("dharagujarati0206@gmail.com","dhara123");
		
		WebElement searchbox= isElementpresent("ip_keywords_name");
		 searchbox.sendKeys(keyword);
		 Thread.sleep(1000); 
		 searchbox.sendKeys(Keys.ENTER);
		 Thread.sleep(1000);
		 myLibrary.getscreenshot("Product", driver);
		  
		 
	}
	@DataProvider
	public Object[][] getproductname()
	{
		return myLibrary.getTestData("SearchProduct", data);
	}

}
