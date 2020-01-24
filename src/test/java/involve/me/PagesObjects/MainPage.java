package involve.me.PagesObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class MainPage extends BasePage {

	@FindBy(css = "#nav-dropdown .text-xs")
	private WebElement accountName;
	@FindBy(css = ".px-4 > a")
	private WebElement createProjectButton;
	@FindBy(css = ".px-5.flex.justify-between.text-base > :nth-child(2)")
	private WebElement totalMyWorkspace;
	@FindBy(css = ".block.text-gray-600")
	private List<WebElement> openMenuProject;
	@FindBy(css = " :nth-child(1) > .absolute  ul > li")
	private List<WebElement> menuProject;
	@FindBy(css = "#confirm-delete-button")
	private WebElement deleteButton;
	// menu account
	@FindBy(css = "#nav-dropdown")
	private WebElement openMenuAccount;
	@FindBy(css = ".max-w-6xl.mx-auto.flex.items-center.justify-between.flex-wrap ul > li")
	private List<WebElement> menuAccountOptions;
	// choose tabs
	@FindBy(css = ".text-sm.flex.items-start > a")
	private List<WebElement> tabList;
	// choose project
	@FindBy(css = ".mt-8 > .relative h1")
	private List<WebElement> chooseProjectList;
	@FindBy(css = ".flex.justify-right.items-center > a > .fill-current")
	private List<WebElement> editProjectList;
	@FindBy(css = ".mt-8 > .relative h1")
	private WebElement projectName;
	// add workspace
	@FindBy(css = ".flex.justify-between > button")
	private WebElement addWorkspaceButton;
	@FindBy(css = "[placeholder='Workspace name']")
	private WebElement workspaceNameField;
	@FindBy(css = "#confirm-create-button")
	private WebElement createButton;
	@FindBy(css = ".mt-6.leading-loose .mr-3.truncate")
	private List<WebElement> chooseWorkspaceList;
	@FindBy(css = "[data-icon='chevron-down']")
	private WebElement openWorkspaceMenu;
	@FindBy(css = ".dropdown.relative.mr-3 > ul > li")
	private List<WebElement> chooseFromWorkspaceList;
	@FindBy(css = "[placeholder='workspaceLiadTest']")
	private WebElement deleteWorkspaceNameField;
	@FindBy(css = "#confirm-create-button")
	private WebElement deleteWorkspaceButton;
	@FindBy(css = ".vue-portal-target input")
	private WebElement renameWorkspaceField;
	@FindBy(css = "#confirm-create-button")
	private WebElement renameButton;
	@FindBy(css = ".text-gray-900")
	private WebElement workspaceName;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	@Step("check accountName after login")
	public String accountName() {
		return getText(accountName);
	}

	@Step("check projectName")
	public String projectName() {
		return getText(projectName);
	}

	@Step("click on create project button")
	public void createProject() {
		click(createProjectButton);
	}

	@Step("check counter projects")
	public int totalProjects() {
		WebDriverWait wait = new WebDriverWait(driver, 15); wait.until(ExpectedConditions.elementToBeClickable(totalMyWorkspace));
		String total = getText(totalMyWorkspace);
		int num = Integer.parseInt(total);
		System.out.println("The number of tasks: " + num);
		return num;
	}

	@Step("open account menu and choose one option from menu {chooseFromOptions}")
	public void yourAccountOption(String chooseFromOptions) {
		click(openMenuAccount);
		sleep(1000);
		for (WebElement el : menuAccountOptions) {
			if (el.getText().equalsIgnoreCase(chooseFromOptions)) {
				el.click();
				sleep(2000);
				break;
			}
		}
	}

	@Step("logout")
	public void logOut(String chooseFromOptions) {
		click(openMenuAccount);
		for (WebElement el : menuAccountOptions) {
			if (el.getText().equalsIgnoreCase(chooseFromOptions)) {
				el.click();
				sleep(2000);
				break;
			}
		}
	}

	@Step("click on tab {chooseTab}")
	public void chooseTab(String chooseTab) {
		for (WebElement el : tabList) {
			if (el.getText().equalsIgnoreCase(chooseTab)) {
				el.click();
				sleep(2000);
				break;
			}
		}
	}

	@Step("click on edit button for project {chooseProject}")
	public void editProject(String chooseProject) {
		for (int i = 0; i < chooseProjectList.size(); i++) {
			if (chooseProjectList.get(i).getText().equalsIgnoreCase(chooseProject)) {
				click(editProjectList.get(i));
			}
		}
	}

	@Step("delete project: {chooseProject}")
	public void deleteProject(String chooseProject, String chooseFromProjectMenu) {
		for (int i = 0; i < chooseProjectList.size(); i++) {
			if (chooseProjectList.get(i).getText().equalsIgnoreCase(chooseProject)) {
				click(openMenuProject.get(i));
				break;
			}
		}
		for (WebElement el : menuProject) {
			if (el.getText().equalsIgnoreCase(chooseFromProjectMenu)) {
				el.click();
				sleep(1000);
				click(deleteButton);
				sleep(1000);
				break;
			}
		}
	}

	@Step("add new workspace {workspaceName}")
	public void addWorkspace(String workspaceName) {
		click(addWorkspaceButton);
		fillText(workspaceNameField, workspaceName);
		click(createButton);
		sleep(2000);
	}

	@Step("check counter workspace")
	public int getWorkspaces(String workspaceName) {
		ArrayList<String> workspaces = new ArrayList<>();
		for (int i = 0; i < chooseWorkspaceList.size(); i++) {
			if (chooseWorkspaceList.get(i).getText().equalsIgnoreCase(workspaceName)) {
				workspaces.add(chooseWorkspaceList.get(i).getText());
			}
		}
		return workspaces.size();
	}

	@Step("check counter after remove workspace")
	public int getWorkspacesRemove(String workspaceName) {
		ArrayList<String> workspaces = new ArrayList<>();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until((ExpectedCondition<Boolean>) driver -> chooseWorkspaceList.size() > 1);
		for (int i = 0; i < chooseWorkspaceList.size(); i++) {
			if (chooseWorkspaceList.get(i).getText().equalsIgnoreCase(workspaceName)) {
				workspaces.remove(chooseWorkspaceList.get(i).getText());
			}
		}
		return workspaces.size();
	}

	@Step("delete workspace: {workspaceName}")
	public void deleteWorkspace(String workspaceName, String workspaceMenu, String deleteWorkspaceName) {
		for (int i = 0; i < chooseWorkspaceList.size(); i++) {
			if (chooseWorkspaceList.get(i).getText().equalsIgnoreCase(workspaceName)) {
				click(chooseWorkspaceList.get(i));
			}
			click(openWorkspaceMenu);
		}
		for (int i = 0; i < chooseFromWorkspaceList.size(); i++) {
			if (chooseFromWorkspaceList.get(i).getText().equalsIgnoreCase(workspaceMenu)) {
				click(chooseFromWorkspaceList.get(i));
			}
		}
		fillText(deleteWorkspaceNameField, deleteWorkspaceName);
		click(deleteWorkspaceButton);
	}

	@Step("rename woekspace {workspaceNameNew}")
	public void renameWorkspace(String workspaceMenu, String workspaceNameNew) {
		click(openWorkspaceMenu);
		sleep(1000);

		for (WebElement el : chooseFromWorkspaceList) {
			if (el.getText().equalsIgnoreCase(workspaceMenu)) {
				el.click();
				break;
			}	
		}
		sleep(1000);
		fillText(renameWorkspaceField, workspaceNameNew);
		sleep(1000);
		click(renameButton);
		sleep(1000);
	}

	@Step("check workspace name")
	public String workspaceName() {
		return getText(workspaceName);
	}

	@Step("duplicate project: {chooseProject}")
	public void duplicateProject(String chooseProject, String chooseFromProjectMenu) {
		for (int i = 0; i < chooseProjectList.size(); i++) {
			if (chooseProjectList.get(i).getText().equalsIgnoreCase(chooseProject)) {
				click(openMenuProject.get(i));
				sleep(1000);
				break;
			}
		}
		for (WebElement el : menuProject) {
			if (el.getText().equalsIgnoreCase(chooseFromProjectMenu)) {
				sleep(1000);
				el.click();
				break;
			}
		}
	}
}
