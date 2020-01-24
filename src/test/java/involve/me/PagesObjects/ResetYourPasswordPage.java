package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ResetYourPasswordPage extends BasePage {

	public ResetYourPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[name='email']")
	private WebElement emailField;
	@FindBy(css = "[type='submit']")
	private WebElement sendButton;
	@FindBy(css = ".alert-danger")
	private WebElement errorResetPasswordMessage;
	@FindBy(css = ".alert-success")
	private WebElement resetPasswordSuccessMessage;

	@Step("type email and click send {email}")
	public void resetPassword(String email) {
		fillText(emailField, email);
		click(sendButton);
	}

	@Step("get error message")
	public String errorResetPassMessage() {
		return getText(errorResetPasswordMessage);
	}

	@Step("get success message")
	public String resetPassSuccessMessage() {
		return getText(resetPasswordSuccessMessage);
	}
}
