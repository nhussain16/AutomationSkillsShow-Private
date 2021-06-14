package appHooks;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.util.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Logger log = Logger.getLogger(ApplicationHooks.class);
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		log.info("**************Test Case Execution Started***************");
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		// Maximizing browser window
		driver.manage().window().maximize();
	}

	@After(order = 0)
	public void closeBrowser() {
		log.info("**************Test Case Execution End***************");
		driver.quit();
	}

	@After(order = 1)
	public void captureScreenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			// capture screenshot
			String screenshotName = scenario.getName().replace(" ", "");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}