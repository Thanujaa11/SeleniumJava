package TestCaseDemo;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Browsers.browser;
import Pages.page1;
public class Test1 {	
	@BeforeMethod
	public void openbrowser()
	{
		browser.init1("Testcase1");
		browser.openBrowser();
		browser.navigateToUrl();
		
	}
	@DataProvider(name="title")
	public Object[] data()
	{
		Object[] obj= {"OrangeHRM"};
		return obj;
	}	
	@Test(priority=1 ,dataProvider = "title")
	public void TestTitle(String title) throws InterruptedException 
	{
		Assert.assertEquals(page1.Title(), title);
		Reporter.log("Screenshot taken by name title");
	}	
	@AfterMethod
	public void closebrowser()
	{
		browser.closeBrowser();
	}
}

