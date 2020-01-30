package involve.me.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import involve.me.PagesObjects.IntegrationsPage;
import involve.me.PagesObjects.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class IntegrationsTest extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Description("move to integrations page")
	@Test(description = "move to integrations page")
	public void t_01moveToIntegrationsPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseTab("Integrations");
		IntegrationsPage integrationsPage = new IntegrationsPage(driver);
		String expected = integrationsPage.title();
		Assert.assertEquals("Integrations", expected);
	}

}
