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
		List<WebElement> chooseTemplate = driver.findElements(By.cssSelector(".c-thumbnail.gallery-item"));
		for (int i = 0; i < chooseTemplate.size(); i++) {
			WebElement titleE = chooseTemplate.get(i).findElement(By.cssSelector(".details-container>h3"));
			String title = getText(titleE);
			if (title.equalsIgnoreCase(template)) {
				Actions action = new Actions(driver);
				action.moveToElement(titleE).build().perform();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".e-button-container a:nth-child(2)>button")));
				WebElement btn = chooseTemplate.get(i).findElement(By.cssSelector(".e-button-container a:nth-child(2)>button"));
				click(btn);
				break;
			}
		}
	}
}
