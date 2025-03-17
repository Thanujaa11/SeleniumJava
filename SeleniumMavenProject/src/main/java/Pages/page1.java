package Pages;
import com.aventstack.extentreports.Status;

import Browsers.browser;
import Locators.page1objects;
import Screenshots.capture;

public class page1 extends browser{
	
	
	//Method for getting the actual title
	public static String Title() throws InterruptedException
	{
		
		extent.attachReporter(reporter);
		logger1 = extent.createTest("ScreenShot");
		logger1.log(Status.INFO, "ScreenShot");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(logger));
		logger1.addScreenCaptureFromPath(capture.screenShot("title"));
		extent.flush();
		return driver.getTitle();
	}
	
	//Entering user name method
	
	public static void enterusername(String str) 
	{
		try 
		{
			extent.attachReporter(reporter);
			logger1=extent.createTest("Enter user name");
			logger1.log(Status.INFO, "Entering username");
				page1objects.username().sendKeys(str);
				logger1.log(Status.PASS, "Entered name successfully");
		}
		catch(Exception E)
		{
			System.out.println("Username :"+E);
			logger1.log(Status.FAIL, "Failed to enter name");
		}
		extent.flush();
		
	}
	
	//Entering password method
		
		public static void enterpassword(String str) 
		{
			try
			{
				extent.attachReporter(reporter);
				logger1=extent.createTest("Enter Password");
				logger1.log(Status.INFO, "Entering Password");
				page1objects.password().sendKeys(str);
				logger1.log(Status.PASS, "Entered Password successfully");
			}
			catch(Exception E)
			{
				System.out.println("Password :"+E);
				logger1.log(Status.FAIL, "Failed to enter Password");
			}
			
			extent.flush();
		}
	
	//clicking method
	
	public static void click() 
	{
		try
		{
			extent.attachReporter(reporter);
			logger1=extent.createTest("Click on Login");
			logger1.log(Status.INFO, "Clicking login button");
			page1objects.login().click();
			logger1.log(Status.PASS, "Login successfully");
		}
		catch(Exception E)
		{
			System.out.println("Click :"+E);
			logger1.log(Status.FAIL, "Failed to Login");
		}
		extent.flush();
	}
}
