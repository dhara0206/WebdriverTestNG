package exercise.Module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import exercise.BasePackage.BaseInit;
import exercise.Utility.myLibrary;

public class ExtractBestSellersLinks extends BaseInit {
	
	@BeforeTest
	public void SetUp() throws Exception
	{
		startUp();
	}

	@Test
	public void testExtractBestSellersLinks() throws InterruptedException
	{
		driver.get(storage.getProperty("url"));
		
		myLibrary.signIn("dharagujarati0206@gmail.com","dhara123");
		
		WebElement Bestsellerdiv=isElementpresent("div_Bestsellers_xpath");
		 
		List<WebElement>  BestSellerValue = Bestsellerdiv.findElements(By.tagName("li"));
		 
		for(int i=0;i<BestSellerValue.size();i++)
		{
			logs.info(BestSellerValue.get(i).getText());
			
			BestSellerValue.get(i).click();
			
			logs.info(driver.getTitle());
			
			myLibrary.getscreenshot("BestSellerLink",driver);
			driver.navigate().back();
			Bestsellerdiv=isElementpresent("div_Bestsellers_xpath");
			 
		    BestSellerValue = Bestsellerdiv.findElements(By.tagName("a"));
		}
		
	}
}
