package involve.me.PagesObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ProjectPage extends BasePage {
	// choose tabs
	@FindBy(css = ".nav.navbar-nav.navbar-right.ml-auto > li > .nav-link")
	private List<WebElement> tabList;
	@FindBy(css = "#bs-example-navbar-collapse-1 > .nav")
	private WebElement tabs;

	public ProjectPage(WebDriver driver) {
		super(driver);
	}

	@Step("choose tab {chooseTab}")
	public void chooseTab(String chooseTab) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(tabs));
		for (WebElement el : tabList) {
			if (el.getText().equalsIgnoreCase(chooseTab)) {
				sleep(1000);
				el.click();
				break;
			}
		}
	}
}
