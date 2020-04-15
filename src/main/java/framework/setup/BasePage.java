package framework.setup;

/**
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Admin
 *
 */
public class BasePage {
	private static WebDriver driver = null;
	public ExtentReports extentReport = null;
	public ExtentTest extentTest = null;

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	@Parameters({ "BROWSER", "URL" })
	public void setup(@Optional("Chrome") String browser, String url) {
		if (driver == null) {
			String curPath = System.getProperty("user.dir");
			extentReport = new ExtentReports(System.getProperty("user.dir") + "\\extentReport.html");
			extentTest = extentReport.startTest("FirstTest");
			switch (browser) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver",
						curPath + "\\src\\main\\java\\framework\\libs\\chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				// DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
				// desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,
				// true);
				driver = new ChromeDriver(chromeOptions);
				driver.get(url);
				extentTest.log(LogStatus.INFO, "Launch Browser and URL loaded");
				break;
			}
			driver.manage().window().maximize();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
