package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;



/** A singleton class that creates a web driver which is then passed into to the constructor of step definition class
 * This allows for re-use of the driver across different definition classes without the need to re-instantiate in each */

public class SharedDriver {


	private static boolean initialized = false;
	private static WebDriver driver;
	private static Scenario message;

	@Before
	public void setUp(Scenario scenario) {
		if (!initialized) {
			//System.setProperty("webdriver.chrome.driver", "exefiles/chromedriver");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--kiosk");
			driver = new ChromeDriver(chromeOptions);
			initialized = true;
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		message = scenario;
	}

	//returns current active webdriver
	public WebDriver getDriver() {
		return driver;
	}
	
	//returns current scenario
	public Scenario getScenario() {
		return message;
	}
	
	

	@After
	//Takes screenshot when a test step fails
	public void killBrowser(Scenario scenario){
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
		initialized=false;
		//Closing the driver.
		driver.quit();
	}
}
