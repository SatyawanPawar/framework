package framework.testcases;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import framework.pageobjects.Dashboard;
import framework.pageobjects.HomePage;
import framework.setup.BasePage;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTests extends BasePage {
	static Logger logger = Logger.getLogger("HomePageTests.class");

	@Test()
	public void testLogin() throws IOException {
		// BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		DOMConfigurator.configure("log4j.xml");
		HomePage homePage = new HomePage();
		homePage.loginToApplication("satyawan", "mp1234$$");
		extentTest.log(LogStatus.INFO, "Entered username and Password");
		logger.info("Login using username and password");
		Reporter.log("Login Successul");
		Dashboard dashboard = new Dashboard();
		if (dashboard.verifyLogin("Flight")) {
			logger.info("Verify successful login meesage");
			Reporter.log("Verification Successul");
			extentTest.log(LogStatus.PASS, "Login Successful");
		} else {
			extentTest.log(LogStatus.FAIL, "Login is failed");
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(capture(getDriver()) + "test failed"));
		}
	}

	private String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("src/main/java/com/pom/pom/screenshots" + System.currentTimeMillis() + ".png");
		String errorFilePath = destFile.getAbsolutePath();
		FileUtils.copyFile(scrFile, destFile);
		return errorFilePath;
	}
}
