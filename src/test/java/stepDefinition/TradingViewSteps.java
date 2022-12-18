package stepDefinition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import PageObjects.BasePage;
import PageObjects.ForexMarketPage;
import PageObjects.SignInPage;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TradingViewSteps {

	private WebDriver driver;
	private Scenario scenario;


	public TradingViewSteps (SharedDriver cs) {
		driver = cs.getDriver();
		scenario = cs. getScenario();
	}
	private BasePage basePage;
	private SignInPage signInPage;
	private ForexMarketPage forexMarketPage;

	//Opening Trading View url in the browser
	@Given("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to_something(String tradingViewUrl) throws Throwable {
		driver.navigate().to(tradingViewUrl);
		scenario.write("Opened Trading view application");
		scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
	}

	//Signing into the Trading View website via 'Email' option
	@And("^sign in to the application$")
	public void sign_in_to_the_application() throws Throwable {
		basePage = new BasePage(driver);
		basePage.clickUserMenu();
		basePage.clickSignInLink();
		signInPage = basePage.clickEmailButton();
		signInPage.enterUsername("tester_brady");
		signInPage.enterPassword("test123");
		forexMarketPage = signInPage.clickSignInButton();
		scenario.write("Succesfully signed in into the application");
		scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
	}

	//Selecting Asia tab in 
	@When("^I select \"([^\"]*)\" tab$")
	public void i_select_something_tab(String tabName) throws Throwable {
		forexMarketPage.selectTab(tabName);
		scenario.write("Selected " +tabName + " tab");
		scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
	}

	//Find the last exchange rate for currency pair GBPJPY 
	@Then("^I should find the last exchange rate for the currency pair \"([^\"]*)\"$")
	public void i_should_find_the_last_exchange_rate_for_the_currency_pair_something(String currencyPair) throws Throwable {
		String exchangeRate = forexMarketPage.getExchangeRate(currencyPair);
		scenario.write("Exchange Rate: " + exchangeRate);
		scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
	}

	//Finding the last three exchange rates for GBPJPY for a period of 1 minute 
	@Then("^I should find the last three exchange rates of currency pair \"([^\"]*)\" for a period of 1 minute$")
	public void i_should_find_the_last_three_exchange_rates_of_currency_pair_something_for_a_period_of_1_minute(String currencyPair) throws Throwable {

		//Finding the exchange rates for GBPJPY every 6 seconds for a period of 1 minute 
		List<String> exchangeRates = new ArrayList<String>();    	
		long endTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(1L, TimeUnit.MINUTES);
		while ( System.nanoTime() < endTime ){  		
			String exchangeRate = forexMarketPage.getExchangeRate(currencyPair);
			System.out.println("Exchange Rate: " + exchangeRate);	    		
			driver.navigate().refresh();
			Thread.sleep(6000);
			if (!exchangeRates.contains(exchangeRate)) {
				exchangeRates.add(exchangeRate);
			}
		}
		scenario.write("Exchange Rates taken in a period 1 minute for an interval of every 6 seconds:" +Arrays.toString(exchangeRates.toArray()));

		//Getting the last 3 exchange rates for GBPJPY in the period of 1 minute
		List<String> last3ExchangeRates = exchangeRates.subList(Math.max(exchangeRates.size() - 3, 0), exchangeRates.size());
		scenario.write("Last 3 Exchange Rates in 1 minute:" +Arrays.toString(last3ExchangeRates.toArray()));
		scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
	}

	//Signing out of the Trading View website
	@And("^I sign out of the application$")
	public void i_sign_out_of_the_application() throws Throwable {
		forexMarketPage.clickSignOut();
		Thread.sleep(1000);
		scenario.write("Signed out of the trading view application");
		scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
	}
}
