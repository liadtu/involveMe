package involve.me.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import involve.me.PagesObjects.MainPage;
import involve.me.PagesObjects.NewProjectPage;
import involve.me.PagesObjects.TemplatesPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class NewProjectTest extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Description("choose template and create new project")
	@Test(description = "choose template")
	public void t_01chooseTemplate() {
		MainPage mainPage = new MainPage(driver);
		int beforeCreateProject = mainPage.totalProjects();
		System.out.println(beforeCreateProject);
		mainPage.chooseTab("Templates");
		TemplatesPage templatesPage = new TemplatesPage(driver);
		templatesPage.getRowForItem("Get Free Kit Lead Page");
		NewProjectPage newProjectPage = new NewProjectPage(driver);
		newProjectPage.createNewProject("liad");
		int afterCreateProject = mainPage.totalProjects();
		Assert.assertEquals(afterCreateProject, beforeCreateProject + 1);
	}
}
