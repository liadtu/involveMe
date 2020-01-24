package involve.me.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import involve.me.PagesObjects.MainPage;
import involve.me.PagesObjects.YourAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class YourAccountTest extends BaseTest{
	YourAccountPage yap = new YourAccountPage(driver);
	
	@Severity(SeverityLevel.NORMAL)
	@Description("open account menu and update account information")
	@Test(description = "update account Information")
	public void t_01updateInformation() {
		MainPage mainPage = new MainPage(driver);
		mainPage.yourAccountOption("Your Account");
		YourAccountPage yourAccountPage = new YourAccountPage(driver);
		yourAccountPage.updateInformation("liad","Tobi");
		String expected = yourAccountPage.accountName();
		System.out.println(expected);
		Assert.assertEquals("liad Tobi", expected);
	}
}
