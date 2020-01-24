package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class GeneralSettingsPage extends BasePage{
	
	@FindBy(css="#project-name")
	private WebElement projectNameField;
	@FindBy(css="#project-language")
	private WebElement selectDefaultLanguage;
	@FindBy(css="#general-settings > :nth-child(3) > button > span")
	private WebElement updateSettingsButton;
	
	public GeneralSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("slecet account setting project name = {projectname } and language value {languagevalue}")
	public void updateSetting(String projectName, String selectLanguageValue) {
		fillText(projectNameField, projectName);
		WebElement el = selectDefaultLanguage;
		Select selectPriority = new Select(el);
		selectPriority.selectByValue(selectLanguageValue);
		click(updateSettingsButton);
		sleep(500);
	}
}
