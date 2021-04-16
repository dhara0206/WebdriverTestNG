package exercise.Module1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import exercise.BasePackage.BaseInit;
import exercise.Utility.myLibrary;

public class CompareWelcomeText extends BaseInit {
	
	@BeforeTest
	public void SetUp() throws Exception
	{
		startUp();
	}
	@Test
	public void testCompareWelcomeText() throws Exception
	{
	   driver.get(storage.getProperty("url"));
	   String welcometxtbeforelogin = isElementpresent("txt_welcome_xpath").getText();
	   myLibrary.signIn("dharagujarati0206@gmail.com", "dhara123");
	   Thread.sleep(1000);
	   String welcometxtafterlogin = isElementpresent("txt_welcome_xpath").getText();
	   logs.info("Welcome text before login is" + welcometxtbeforelogin);
	   logs.info("Welcome text before login is" + welcometxtafterlogin);
	   
	   if(!welcometxtbeforelogin.equals(welcometxtafterlogin))
	   {
		  logs.info("Login successfully"); 
		  myLibrary.signOut();
	   }
	   else
	   {
		   logs.info("Invalid Username and Password");
	   }
	}

}
