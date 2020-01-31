package involve.me.PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class TemplatesPage extends BasePage {

	@FindBy(css = "#template-gallery [role='row'] img")
	private List<WebElement> chooseTemplate;
	@FindBy(css = "tr:nth-child(16) a:nth-child(2) > button")
	private WebElement chooseButton;

	public TemplatesPage(WebDriver driver) {
		super(driver);
	}

	@Step("choose template {template}")
	public void getRowForItem(String template) {
		List<WebElement> chooseTemplate = driver.findElements(By.cssSelector(".details-container > h3"));
		for (int i = 0; i < chooseTemplate.size(); i++) {
			if (getText(chooseTemplate.get(i)).equalsIgnoreCase(template)) {
				Actions action = new Actions(driver);
				action.moveToElement(chooseTemplate.get(i)).build().perform();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(chooseButton));
				click(chooseButton);
				break;
			}
		}
	}
}
