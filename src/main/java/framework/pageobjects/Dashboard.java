package framework.pageobjects;

/**
 * 
 */
import org.openqa.selenium.WebDriver;

import framework.setup.BasePage;

/**
 * @author Admin
 *
 */
public class Dashboard {
	private WebDriver driver = null;

	public Dashboard() {
		driver = BasePage.getDriver();
	}

	public boolean verifyLogin(String title) {
		if (driver.getTitle().contains(title)) {
			return true;
		} else {
			return false;
		}
	}

}
