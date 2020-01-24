package involve.me.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import involve.me.PagesObjects.MainPage;
import involve.me.PagesObjects.OrganizationSettingPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utilities.AllureAttachment;

public class OrganizationSettingsTest extends BaseTest{
	
	@Severity(SeverityLevel.NORMAL)
	@Description("edit organization name")
	@Test(description = "change organization name")
	public void t_01changeOrganizationName() {
		MainPage mainPage = new MainPage(driver);
		mainPage.yourAccountOption("Change organization");
		OrganizationSettingPage organizationSetting = new OrganizationSettingPage(driver);
		organizationSetting.getRowForItem("Liad");
		organizationSetting.editOrganization("Liad");
		String expected = organizationSetting.organizationName();
		AllureAttachment.addTextAttachment(expected);
		System.out.println(expected);
		Assert.assertEquals("Liad", expected);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("check that can't create new organization if name don't valid")
	@Test(description = "error message when try create organization")
	public void t_02createNewOrganization() {
		OrganizationSettingPage organizationSetting = new OrganizationSettingPage(driver);
		organizationSetting.createOrganization("SSS");
		String exepted = organizationSetting.notAvailable();
		System.out.println(exepted);
		Assert.assertEquals("not available", exepted);
	}	
	
	@Severity(SeverityLevel.NORMAL)
	@Description("change oragnization")
	@Test(description = "change oragnization")
	public void t_03changeOrganization() {
		OrganizationSettingPage organizationSetting = new OrganizationSettingPage(driver);
		organizationSetting.cancelCreateOrganization();
		organizationSetting.chooseOrganization("newO");
		MainPage mainPage = new MainPage(driver);
		String exepted = mainPage.accountName();
		Assert.assertEquals("newO", exepted);
	}	
}
