package TestCaseDemo;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Browsers.browser;
import Locators.page2object;
import Pages.page1;
import Pages.page2;
public class Test3 {
	@BeforeMethod
	public void openbrowser()
	{
		browser.init1("Testcase3");
		browser.openBrowser();
		browser.navigateToUrl();		
	}	
	@Test
	public void TestMenu()
	{
		page1.enterusername("Admin");
		page1.enterpassword("admin123");
		page1.click();
		page2.optionclick("leave");
		Assert.assertEquals(page2object.menuName().getText(),"Leave");
	}	
	@AfterMethod
	public void closebrowser()
	{
		browser.closeBrowser();
	}
}
