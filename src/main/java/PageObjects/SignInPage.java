package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//TradingView Sign in page
public class SignInPage {

	private WebDriver driver;

	public SignInPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private static final String USERNAME_XPATH = "//input[@name='username']";
	private static final String PASSWORD_XPATH = "//input[@name='password']";
	private static final String SIGNIN_BUTTON_XPATH = "//button[@type='submit']";

	@FindBy(xpath = USERNAME_XPATH)
	private WebElement username;

	@FindBy(xpath = PASSWORD_XPATH)
	private WebElement password;

	@FindBy(xpath = SIGNIN_BUTTON_XPATH)
	private WebElement signInButton;

	public void enterUsername(String userName) {
		username.clear();
		username.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		password.clear();
		password.sendKeys(passWord);
	}

	public ForexMarketPage clickSignInButton() {
		signInButton.click();
		return PageFactory.initElements(driver, ForexMarketPage.class);

	}




}
