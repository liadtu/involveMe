package involve.me.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import involve.me.PagesObjects.AffiliateProgramPage;
import involve.me.PagesObjects.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AffiliateProgramTest extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Description("move to affiliate program page")
	@Test(description = "move to affiliate program page")
	public void t_01moveToAffiliateProgramPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.chooseTab("Affiliate Program");
		AffiliateProgramPage affiliateProgram = new AffiliateProgramPage(driver);
		String expected = affiliateProgram.title();
		Assert.assertEquals("Affiliate Program", expected);
	}

}
