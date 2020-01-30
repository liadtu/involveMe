package involve.me.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import involve.me.PagesObjects.AnalyticsPage;
import involve.me.PagesObjects.MainPage;
import involve.me.PagesObjects.OverallAnalyticsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class OverallAnalyticsTest extends BaseTest {
	
	@Severity(SeverityLevel.NORMAL)
	@Description("Show analytics and submissions for a single project")
	@Test(description = "show analytics for single project")
	public void t_01showAnalyticsForSingleProject() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseTab("Analytics");
		OverallAnalyticsPage overallAnalytics = new OverallAnalyticsPage(driver);
		overallAnalytics.selectProjectAnalytics();
		AnalyticsPage analyticsPage = new AnalyticsPage(driver);
		String expected = analyticsPage.title();
		Assert.assertEquals("Analytics", expected);
	}
}
