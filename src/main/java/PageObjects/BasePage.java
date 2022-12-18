package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//BasePage or Trading view page
public class BasePage {

	protected WebDriver driver;

	public BasePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private static final String USER_MENU_XPATH = "//button[@aria-label='Open user menu' and contains(@class, 'anonymous')]";
	private static final String SIGN_IN_LINK_XPATH = "//span[contains(text(), 'Sign in')]";
	private static final String EMAIL_BUTTON = "//span[contains(text(), 'Email')]";

	@FindBy(xpath = USER_MENU_XPATH)
	private WebElement userMenu;

	@FindBy(xpath = SIGN_IN_LINK_XPATH)
	private WebElement signInLink;

	@FindBy(xpath = EMAIL_BUTTON)
	private WebElement emailButton;

	public void clickUserMenu() {
		userMenu.click();
	}

	public void clickSignInLink() {
		signInLink.click();

	}

	public SignInPage clickEmailButton() {
		emailButton.click();
		return PageFactory.initElements(driver, SignInPage.class);

	}


}
