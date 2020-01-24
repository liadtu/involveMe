package involve.me.PagesObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ProjectPage extends BasePage{
	// choose tabs
		@FindBy(css = ".nav.navbar-nav.navbar-right.ml-auto > li > .nav-link")
		private List<WebElement> tabList;

	public ProjectPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("choose tab {chooseTab}")
	public void chooseTab(String chooseTab) {
		for (WebElement el : tabList) {
			if (el.getText().equalsIgnoreCase(chooseTab)) {
				el.click();
				sleep(2000);
				break;
			}
		}
	}
}
