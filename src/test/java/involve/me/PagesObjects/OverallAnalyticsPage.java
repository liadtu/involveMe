package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OverallAnalyticsPage extends BasePage {

	public OverallAnalyticsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "[name='projects_analytics']")
	private WebElement selectProjectsAnalytics;
	
	public void selectProjectAnalytics() {
		Select projectsAnalytics = new Select(selectProjectsAnalytics);
		projectsAnalytics.deselectByIndex(1);
	}

}
