package exercise.Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import exercise.BasePackage.BaseInit;

public class myLibrary extends BaseInit {
	
	public static void signIn(String username,String pws)
	{
		
		isElementpresent("lnk_logyourselfin_linkText").click();
		isElementpresent("ip_emailAdd_name").sendKeys(username);
		isElementpresent("ip_password_name").sendKeys(pws);
		isElementpresent("btn_signin_id").click();
	}

	public static void signOut()
	{
		isElementpresent("lnk_logoff_linkText").click();
		isElementpresent("btn_continue_id").click();
	}
	
	
    public static Object[][] getTestData(String testCase, ExcelFileReader data) 
    {
		
		int cols = data.totalColumn(testCase);
		int rows = data.totalRow(testCase);
		
		Object[][] myData = new Object[rows-1][cols];
		
		for(int row=1;row<rows;row++) 
		{
			
			for(int col=0;col<cols;col++) 
			{
				
				myData[row-1][col] = data.getData(testCase, row, col);
			}
			
		}
		
		return myData;
    }
    public static String getscreenshot(String imagename, WebDriver driver)
    {
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File scrfile=ts.getScreenshotAs(OutputType.FILE);
		
		
		String path = System.getProperty("user.dir")+"\\src\\exercise\\ScreenShots\\"+imagename+System.currentTimeMillis()+".png";
		
		File Destination= new File(path);
		
    	try 
    	{
    		FileHandler.copy(scrfile, Destination);
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	return path;
    	
    }

}
