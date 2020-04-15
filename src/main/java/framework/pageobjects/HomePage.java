package framework.pageobjects;

/**
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.setup.BasePage;

/**
 * @author Admin
 *
 */
public class HomePage {
	private WebDriver driver = null;

	// WebElements Locators
	By signOnLink = By.xpath("//a[text()='SIGN-ON']");
	By userEmail = By.xpath("//input[@name='userName']");
	By password = By.xpath("//input[@name='password']");
	By signinButton = By.xpath("//input[@name='login']");

	public HomePage() {
		driver = BasePage.getDriver();
	}

	public void loginToApplication(String username, String password) {

		driver.findElement(signOnLink).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		driver.findElement(userEmail).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(signinButton).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
}
