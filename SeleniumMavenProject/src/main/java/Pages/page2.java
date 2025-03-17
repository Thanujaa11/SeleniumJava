package Pages;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import Browsers.browser;
import Locators.page2object;
public class page2 extends browser {	
		public static String Username()
		{
			return page2object.username().getText();
		}	
		//clicking method	
		public static void optionclick(String str) 
		{
			extent.attachReporter(reporter);
			logger1=extent.createTest("Click on Leave");
			logger1.log(Status.INFO, "Clicking on Leave button");
			try{
				List<WebElement> list=page2object.menuelements();
				for(WebElement e:list)
				{
					if(e.getText().equalsIgnoreCase(str))
					{	e.click();
						break; }
				}
				logger1.log(Status.PASS, "Clicked on leave successfully");
				}
			
			catch(Exception E)
			{
				System.out.println("Click :"+E);
				logger1.log(Status.FAIL, "Failed to click leave button");
			}	
		}		
		public static String MenuName()
		{
			return page2object.menuName().getText();
		}
}

