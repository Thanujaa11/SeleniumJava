package Screenshots;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;

import Browsers.browser;

public class capture extends browser {
	
	public static String screenShot(String name)  { 
		String path = null;
		try {
			TakesScreenshot shot = ((TakesScreenshot) driver);
			File source = shot.getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir") + "\\target\\ScreenShot\\" + name + ".png";
			File destination = new File(path);
			
			//logger1.log(Status.PASS, "captured successfully");
			
			source.renameTo(destination);
			
		} catch (Exception e) {
			System.out.println("Screenshot");
			//logger1.log(Status.FAIL, "Failed to capture");
		}
		return path;
	}

}
