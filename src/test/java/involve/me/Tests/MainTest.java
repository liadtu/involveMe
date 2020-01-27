package involve.me.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import involve.me.PagesObjects.ChooseProjectTypePage;
import involve.me.PagesObjects.MainPage;
import involve.me.PagesObjects.NewProjectPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class MainTest extends BaseTest {

	@Link("https://selenium.teachable.com/courses/529400/lectures/10100519")
	@Link("www.ggogle.co.il")
	@Severity(SeverityLevel.NORMAL)
	@Description("add and delete project from workspace")
	@Test(enabled = false, description = "delete project")
	public void t_01deleteProject() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.createProject();
		ChooseProjectTypePage chooseProjectTypePage = new ChooseProjectTypePage(driver);
		chooseProjectTypePage.blankProject();
		NewProjectPage newProjectPage = new NewProjectPage(driver);
		newProjectPage.createNewProject("deleteProject");
		int beforeDeleteProject = mainPage.totalProjects();
		System.out.println(beforeDeleteProject);
		mainPage.deleteProject("deleteProject", "Delete Project");
		int afterDeleteProject = mainPage.totalProjects();
		System.out.println(afterDeleteProject);
		Assert.assertEquals(afterDeleteProject, beforeDeleteProject - 1);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("add new workspace")
	@Test(enabled = false, description = "add workspace")
	public void t_02addNewWorkspace() {
		MainPage mainPage = new MainPage(driver);
		int start = mainPage.getWorkspaces("workspaceLiadTest");
		mainPage.addWorkspace("workspaceLiadTest");
		int end = mainPage.getWorkspaces("workspaceLiadTest");
		Assert.assertEquals(start + 1, end);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("delete workspace")
	@Test(enabled = false, description = "delete workspace")
	public void t_03deleteWorkspace() {
		MainPage mainPage = new MainPage(driver);
		int start = mainPage.getWorkspacesRemove("workspaceLiadTest");
		mainPage.deleteWorkspace("workspaceLiadTest", "Delete Workspace", "workspaceLiadTest");
		int end = mainPage.getWorkspacesRemove("workspaceLiadTest");
		Assert.assertEquals(start, end);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("rename workspace")
	@Test(enabled = true, description = "rename workspace")
	public void t_04renameWorkspace() {
		MainPage mainPage = new MainPage(driver);
		mainPage.renameWorkspace("Liad");
		String expected = mainPage.workspaceName();
		Assert.assertEquals("Liad", expected);
	}
}
