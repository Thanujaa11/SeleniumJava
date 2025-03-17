package Browsers;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class browser {
	
	public static WebDriver driver;
	public static WebElement element;
	public static WebDriverWait wait;
	public static Actions act;
	public static Select select;
	
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest logger1;
	
	public static void init1(String reportName) {
		extent=new ExtentReports();
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//target//ExtentReports//"+reportName+".html");
	}
		
	public static void openBrowser()  {
		
		try {
			extent.attachReporter(reporter);
			logger1=extent.createTest("Open Browser");
			logger1.log(Status.INFO, "Opening browser");
			String choice = utility.properties("browser"); 
			if (choice.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}
			else if (choice.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			}
			else if (choice.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}
			logger1.log(Status.PASS, "Crome openend successfully");
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Browser - openBrowser "+e);
			logger1.log(Status.FAIL, "Failed opening browser");
		}
		extent.flush();
	}
	
		/*
		 * Pauses the URL of the application
		 */
		public static void navigateToUrl() {
			
			try {
				extent.attachReporter(reporter);
				logger1=extent.createTest("Navigate to Url ");
				logger1.log(Status.INFO, "Opening url");
				String Url = utility.properties("url");
				driver.get(Url); 
				driver.manage().window().maximize();
				act = new Actions(driver);
				String title=driver.getTitle();
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.titleIs(title));
				logger1.log(Status.PASS, "Navigate to other url successfully");
			} catch (Exception e) {
				System.out.println("Browser - navigatetoUrl "+e);
				logger1.log(Status.FAIL, "Failed to navigate");
			}
			extent.flush();
		}
		/*
		 * Closes the Browser
		 */
		public static void closeBrowser() {
			try {
				extent.attachReporter(reporter);
				logger1=extent.createTest("Close Browser");
				logger1.log(Status.INFO, "Closing browser");
				driver.quit();
				logger1.log(Status.PASS, "closed successfully");
			} catch (Exception e) {
				System.out.println("Browser - closeBrowser "+e);
				logger1.log(Status.FAIL, "Failed to close");
			}
			extent.flush();
		}
		

}

