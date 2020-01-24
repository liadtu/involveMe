package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class LogInPage extends BasePage {

	@FindBy(css = "[name='email']")
	private WebElement emailField;
	@FindBy(css = "[name='password']")
	private WebElement passwordField;
	@FindBy(css = ".btn-lg")
	private WebElement logInButton;
	@FindBy(css = ".alert-danger")
	private WebElement logInErrMessage;
	@FindBy(css = ".e-form-heading")
	private WebElement logInTitle;
	@FindBy(css=".form-login> :nth-child(6) a")
	private WebElement forgotPasswordButton;

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * login to invlove me
	 * 
	 * @param email    - the user email
	 * @param password
	 */
	@Step("type {email} and {password} and click login")
	public void login(String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		click(logInButton);
		sleep(2000);
	}
	
	@Step("check login error massage")
	public String errLogIn() {
		return getText(logInErrMessage);
	}
	
	@Step("check login title")
	public String logInTitle() {
		return getText(logInTitle);
	}
	
	@Step("forgot password")
	public void forgotPassword() {
		click(forgotPasswordButton);
	}
}
