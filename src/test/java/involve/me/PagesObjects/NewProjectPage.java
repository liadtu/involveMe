package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class NewProjectPage extends BasePage {

	@FindBy(css = "#new-project-form #project-name")
	private WebElement projectNameField;
	@FindBy(css = ".swal-button.swal-button--confirm")
	private WebElement startEditingButton;
	@FindBy(css = ".e-close")
	private WebElement saveAndExitButton;

	public NewProjectPage(WebDriver driver) {
		super(driver);
	}

	@Step("type name for new project = {projectName} and after create project click saveAndExitButton")
	public void createNewProject(String projectName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(projectNameField));
		fillText(projectNameField, projectName);
		click(startEditingButton);
		click(saveAndExitButton);
	}
}
