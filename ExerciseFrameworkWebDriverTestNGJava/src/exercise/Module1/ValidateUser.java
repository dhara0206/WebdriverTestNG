package exercise.Module1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import exercise.BasePackage.BaseInit;
import exercise.Utility.myLibrary;

public class ValidateUser extends BaseInit {
	
	@BeforeTest
	public void SetUp() throws Exception
	{
		startUp();
	}
	@Test(dataProvider="getTestDataFromXLS")
	public void testValidateUser(String email,String pwd) throws InterruptedException
	{
		driver.get(storage.getProperty("url"));
		Thread.sleep(1000);
		myLibrary.signIn(email,pwd);
		
		myLibrary.getscreenshot("User",driver);
		boolean logofftext = isElementpresent("lnk_logoff_linkText").isEnabled();
		
	
		if(logofftext == true)
		{
			
			logs.info("Sessin has been started");
			Thread.sleep(1000);
			myLibrary.signOut();

		}
		else
		{
			logs.info("Invalid Username Or Password");
		}
	}
	@DataProvider
	public Object[][] getTestDataFromXLS() {
		
		return myLibrary.getTestData("ValidateUser",data);
					
	}

}
