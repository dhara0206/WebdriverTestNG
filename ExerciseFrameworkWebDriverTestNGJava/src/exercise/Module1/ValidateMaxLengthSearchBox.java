package exercise.Module1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import exercise.BasePackage.BaseInit;
import exercise.Utility.myLibrary;

public class ValidateMaxLengthSearchBox extends BaseInit {
	
	@BeforeTest
	public void SetUp() throws Exception
	{
		startUp();
	}
	@Test
	public void testValidateMaxLengthSearchBox()
	{
		driver.get(storage.getProperty("url"));
		myLibrary.signIn("dharagujarati0206@gmail.com", "dhara123");
	    String maxlength = isElementpresent("ip_keywords_name").getAttribute("maxlength");
	    int i = Integer.parseInt(maxlength);
	    logs.info("Maxlength is" + i);
	    
	    if(i==30)
		{
			System.out.println("TestCase is Pass");
			myLibrary.signOut();
		}
		else
		{
			System.out.println("TestCase is Faile");
		}
	    
	}
}
