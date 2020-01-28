package involve.me.PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class OrganizationSettingPage extends BasePage {

	public OrganizationSettingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[title='Edit organization']")
	private WebElement editButton;
	@FindBy(css = ".w-full.mb-8 a")
	private List<WebElement> chooseOrganization;
	@FindBy(css = "[placeholder='Organization name']")
	private WebElement organizationNameField;
	@FindBy(css = "#confirm-create-button")
	private WebElement createButton;
	@FindBy(css = ".w-full.mb-8 a")
	private WebElement organizationName;
	@FindBy(css=".flex > .text-sm")
	private WebElement notAvailableMessage;
	@FindBy(css=".px-3.py-2")
	private WebElement createNewOrganizationButton;
	@FindBy(css="[type='button']")
	private WebElement cancelButton;


	@Step("click edit organization {organizationName}")
	public void editOrganization(String organizationName) {
		click(editButton);
		fillText(organizationNameField, organizationName);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(createButton));
		click(createButton);
	}
	
	@Step("check organizationName")
	public String organizationName() {
		return getText(organizationName);
	}
	
	@Step("choose organization")
	public void chooseOrganization(String organizationName) {
		for (WebElement el : chooseOrganization) {
			if (el.getText().equalsIgnoreCase(organizationName)) {
				el.click();
				break;
			}
		}
	}
	
	@Step("enter not available name for organization")
	public void createOrganization(String organizationName) {
		click(createNewOrganizationButton);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(organizationNameField));
		fillText(organizationNameField, organizationName);
	}
	
	@Step("check 'not available' message")
	public String notAvailable() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return !(notAvailableMessage.getText().contains("checking..."));
            }
        });
		return getText(notAvailableMessage);
	}
	
	@Step("move mouse to name of organization")
	public int getRowForItem(String name) {
		List<WebElement> listOrganizations = driver.findElements(By.cssSelector(".w-full.mb-8 a"));
		for (int i = 0; i < listOrganizations.size(); i++) {
			if (getText(listOrganizations.get(i)).equalsIgnoreCase(name)) {
				Actions action = new Actions(driver);
				action.moveToElement(listOrganizations.get(i)).build().perform();
				return i;
			}
		}
		return -1;
	}
	
	@Step("click cancel button")
	public void cancelCreateOrganization() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
		click(cancelButton);
	}
	
}
