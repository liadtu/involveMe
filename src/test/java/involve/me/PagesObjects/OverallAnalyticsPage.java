package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class OverallAnalyticsPage extends BasePage {

	public OverallAnalyticsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[name='projects_analytics']")
	private WebElement selectProjectsAnalytics;

	@Step("choose project from select")
	public void selectProjectAnalytics() {
		Select projectsAnalytics = new Select(selectProjectsAnalytics);
		projectsAnalytics.selectByIndex(1);
	}

}
