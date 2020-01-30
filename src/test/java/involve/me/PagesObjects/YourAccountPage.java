package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class YourAccountPage extends BasePage {
	@FindBy(css = "#tab-edit")
	private WebElement updateInformationButton;
	@FindBy(css = "[name='first_name']")
	private WebElement firstNameField;
	@FindBy(css = "[name='last_name']")
	private WebElement lastNameField;
	@FindBy(css = "#edit .btn")
	private WebElement updateButton;
	@FindBy(css = ".table.table-striped.table-hover.table-bordered :nth-child(1) :nth-child(1) .text-left")
	private WebElement nameText;
	@FindBy(css = "[aria-controls='password']")
	private WebElement changePasswordButton;
	@FindBy(css = "[name='old_password']")
	private WebElement oldPasswordField;
	@FindBy(css = "[name='password']")
	private WebElement newPasswordField;
	@FindBy(css = "[name='password_confirmation']")
	private WebElement newPasswordConfirmationField;
	@FindBy(css = "#password [type='submit']")
	private WebElement updatePasswordButton;
	@FindBy(css = ".alert-success")
	private WebElement successChangePasswordMessage;

	public YourAccountPage(WebDriver driver) {
		super(driver);
	}

	@Step("update account information {firstName} {lastName}")
	public void updateInformation(String firstName, String lastName) {
		click(updateInformationButton);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		click(updateButton);
	}

	@Step("check account name")
	public String accountName() {
		return getText(nameText);
	}

	@Step("click on change Password tab and type old password, new password and new password confirmation")
	public void changePassword(String oldPass, String newPass, String newPassConfirmation) {
		click(changePasswordButton);
		fillText(oldPasswordField, oldPass);
		fillText(newPasswordField, newPass);
		fillText(newPasswordConfirmationField, newPassConfirmation);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(updatePasswordButton));
		click(updatePasswordButton);
	}

	@Step("success change password message")
	public String successChangePasswordMessage() {
		return getText(successChangePasswordMessage);
	}
}
