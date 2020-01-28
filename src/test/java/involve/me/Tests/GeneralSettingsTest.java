package involve.me.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import involve.me.PagesObjects.ChooseProjectTypePage;
import involve.me.PagesObjects.GeneralSettingsPage;
import involve.me.PagesObjects.MainPage;
import involve.me.PagesObjects.NewProjectPage;
import involve.me.PagesObjects.ProjectPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class GeneralSettingsTest extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Description("create new project and update settings for project")
	@Test(description = "update settings")
	public void t_01changeProjectSettings() {
		MainPage mainPage = new MainPage(driver);
		mainPage.createProject();
		ChooseProjectTypePage chooseProjectTypePage = new ChooseProjectTypePage(driver);
		chooseProjectTypePage.blankProject();
		NewProjectPage newProjectPage = new NewProjectPage(driver);
		newProjectPage.createNewProject("firstProject");
		mainPage.editProject("firstProject");
		ProjectPage projectPage = new ProjectPage(driver);
		projectPage.chooseTab("Settings");
		GeneralSettingsPage generalSettingsPage = new GeneralSettingsPage(driver);
		generalSettingsPage.updateSetting("liadTestSetting", "he");
		mainPage.chooseTab("Projects");
		String expected = mainPage.projectName();
		System.out.println(expected);
		Assert.assertEquals("liadTestSetting", expected);
	}
}
