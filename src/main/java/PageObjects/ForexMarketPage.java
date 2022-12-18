package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ForexMarketPage {

	private WebDriver driver;

	public ForexMarketPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private static final String TAB_XPATH = "//div[contains(text(), '%s')]";
	private static final String EXCHANGE_RATE_XPATH = "//tr[@data-symbol='FX_IDC:%s']//td[2]/span";
	private static final String USER_MENU_BUTTON_XPATH = "//button[contains(@class, 'button--logged')]";
	private static final String SIGNOUT_LINK_XPATH = "//span[contains(text(), 'Sign Out')]";

	@FindBy(xpath = USER_MENU_BUTTON_XPATH)
	private WebElement usermenuButton;

	@FindBy(xpath = SIGNOUT_LINK_XPATH)
	private WebElement signOutLink;

	public void selectTab(String tabName) {
		WebElement countryTab = driver.findElement(By.xpath(String.format(TAB_XPATH, tabName)));
		countryTab.click();
	}

	public String getExchangeRate(String currencyPair) {
		WebElement exchangeRate = driver.findElement(By.xpath(String.format(EXCHANGE_RATE_XPATH, currencyPair)));
		return exchangeRate.getText();
	}

	public void clickSignOut() {
		usermenuButton.click();
		signOutLink.click();
	}

}
