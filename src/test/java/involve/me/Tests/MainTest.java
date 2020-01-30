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
	@Test(description = "delete project")
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
	@Test(description = "add workspace")
	public void t_02addNewWorkspace() {
		MainPage mainPage = new MainPage(driver);
		int start = mainPage.getWorkspaces("workspaceLiadTest");
		mainPage.addWorkspace("workspaceLiadTest");
		int end = mainPage.getWorkspaces("workspaceLiadTest");
		Assert.assertEquals(start, end);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("delete workspace")
	@Test(description = "delete workspace")
	public void t_03deleteWorkspace() {
		MainPage mainPage = new MainPage(driver);
		int start = mainPage.getWorkspacesRemove("workspaceLiadTest");
		mainPage.deleteWorkspace("workspaceLiadTest", "workspaceLiadTest");
		int end = mainPage.getWorkspacesRemove("workspaceLiadTest");
		Assert.assertEquals(start, end);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("rename workspace")
	@Test(description = "rename workspace")
	public void t_04renameWorkspace() {
		MainPage mainPage = new MainPage(driver);
		mainPage.renameWorkspace("Liad");
		String expected = mainPage.workspaceName();
		Assert.assertEquals("Liad", expected);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("move to complete tab and check that appear that don't have projects in this tab")
	@Test(description = "move to complete tab")
	public void t_05compleateProjectTab() {
		MainPage mainPage = new MainPage(driver);
		mainPage.moveToCompleteTab();
		String expected = mainPage.noProjectMatchesMessage();
		Assert.assertEquals("No project matches the criteria ", expected);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("search project that doesn't exist and check that appear that don't have projects in this tab")
	@Test(description = "search project that doesn't exist")
	public void t_06searchFaild() {
		MainPage mainPage = new MainPage(driver);
		mainPage.search("bla");
		String expected = mainPage.noProjectMatchesMessage();
		Assert.assertEquals("No project matches the criteria ", expected);
	}
}
