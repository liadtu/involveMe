package involve.me.PagesObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	@FindBy(css = ".w-full.hidden ul")
	private WebElement menuAccount;
	// choose tabs
	@FindBy(css = ".text-sm.flex.items-start > a")
	private List<WebElement> tabList;
	@FindBy(css = ".text-sm.flex.items-start")
	private WebElement tabs;
	// choose project
	@FindBy(css = "h1 > a")
	private List<WebElement> chooseProjectList;
	@FindBy(css = ".flex.justify-right > a")
	private WebElement editProject;
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
	@FindBy(css = ".mt-6.leading-loose")
	private WebElement workspaceList;
	@FindBy(css = "[data-icon='chevron-down']")
	private WebElement openWorkspaceMenu;
	@FindBy(css = ".dropdown.relative.mr-3 > ul > li")
	private List<WebElement> chooseFromWorkspaceList;
	@FindBy(css = ".dropdown.relative.mr-3 > ul")
	private WebElement workspaceMenu;
	@FindBy(css = "[placeholder='workspaceLiadTest']")
	private WebElement deleteWorkspaceNameField;
	@FindBy(css = "#confirm-create-button")
	private WebElement deleteWorkButton;
	@FindBy(css = ".vue-portal-target input")
	private WebElement renameWorkspaceField;
	@FindBy(css = "#confirm-create-button")
	private WebElement renameButton;
	@FindBy(css = ".text-gray-900")
	private WebElement workspaceName;
	@FindBy(xpath = "//button[text()='Rename Workspace']")
	private WebElement renameWorkspaceButton;
	@FindBy(xpath = "//button[text()='Delete Workspace']")
	private WebElement deleteWorkspaceButton;
	@FindBy(css = ".text-indigo-600")
	private WebElement complateProjectTab;
	@FindBy(css = ".flex-col > h1")
	private WebElement noProjectMessage;
	@FindBy(css = "[data-icon='search']")
	private WebElement searchButton;
	@FindBy(css=".rounded.h-8.bg-transparent")
	private WebElement searchProjectField;

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
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-gray-900")));
		sleep(1000);
		String total = getText(totalMyWorkspace);
		int num = Integer.parseInt(total);
		System.out.println("The number of tasks: " + num);
		return num;
	}

	@Step("open account menu and choose one option from menu {chooseFromOptions}")
	public void yourAccountOption(String chooseFromOptions) {
		click(openMenuAccount);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(menuAccount));
		for (WebElement el : menuAccountOptions) {
			if (el.getText().equalsIgnoreCase(chooseFromOptions)) {
				el.click();
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
				break;
			}
		}
	}

	@Step("click on tab {chooseTab}")
	public void chooseTab(String chooseTab) {
		for (WebElement el : tabList) {
			if (el.getText().equalsIgnoreCase(chooseTab)) {
				sleep(2000);
				el.click();
				break;
			}
		}
	}

	@Step("click on edit button for project {chooseProject}")
	public void editProject(String chooseProject) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(editProject));
		for (int i = 0; i < chooseProjectList.size(); i++) {
			if (chooseProjectList.get(i).getText().equalsIgnoreCase(chooseProject)) {
				click(editProject);
				break;
			}
		}
	}

	@Step("open the menu project of {chooseProject} and choose {chooseFromProjectMenu} ")
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
				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
				click(deleteButton);
				break;
			}
		}
	}

	@Step("add new workspace {workspaceName}")
	public void addWorkspace(String workspaceName) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(addWorkspaceButton));
		click(addWorkspaceButton);
		fillText(workspaceNameField, workspaceName);
		click(createButton);
	}

	@Step("check counter workspace")
	public int getWorkspaces(String workspaceName) {
		ArrayList<String> workspaces = new ArrayList<>();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until((ExpectedCondition<Boolean>) driver -> chooseWorkspaceList.size() > 0);
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
		wait.until((ExpectedCondition<Boolean>) driver -> chooseWorkspaceList.size() > 0);
		for (int i = 0; i < chooseWorkspaceList.size(); i++) {
			if (chooseWorkspaceList.get(i).getText().equalsIgnoreCase(workspaceName)) {
				workspaces.remove(chooseWorkspaceList.get(i).getText());
			}
		}
		return workspaces.size();
	}

	@Step("delete workspace: {workspaceName}")
	public void deleteWorkspace(String workspaceName, String deleteWorkspaceName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(workspaceList));
		for (int i = 0; i < chooseWorkspaceList.size(); i++) {
			if (chooseWorkspaceList.get(i).getText().equalsIgnoreCase(workspaceName)) {
				click(chooseWorkspaceList.get(i));
			}
			wait.until(ExpectedConditions.elementToBeClickable(openWorkspaceMenu));
			click(openWorkspaceMenu);
		}
		wait.until(ExpectedConditions.elementToBeClickable(deleteWorkspaceButton));
		click(deleteWorkspaceButton);
		wait.until(ExpectedConditions.elementToBeClickable(deleteWorkspaceNameField));
		fillText(deleteWorkspaceNameField, deleteWorkspaceName);
		wait.until(ExpectedConditions.elementToBeClickable(deleteWorkButton));
		click(deleteWorkButton);
	}

	@Step("rename woekspace {workspaceNameNew}")
	public void renameWorkspace(String workspaceNameNew) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(openWorkspaceMenu));
		click(openWorkspaceMenu);
		click(renameWorkspaceButton);
		wait.until(ExpectedConditions.elementToBeClickable(renameWorkspaceField));
		fillText(renameWorkspaceField, workspaceNameNew);
		wait.until(ExpectedConditions.elementToBeClickable(renameButton));
		click(renameButton);
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
				break;
			}
		}
		for (WebElement el : menuProject) {
			if (el.getText().equalsIgnoreCase(chooseFromProjectMenu)) {
				el.click();
				break;
			}
		}
	}

	@Step("move to complate project tab")
	public void moveToCompleteTab() {
		click(complateProjectTab);
	}

	@Step("check that appear message if don't projects in tab")
	public String noProjectMatchesMessage() {
		return getText(noProjectMessage);
	}

	@Step("search project")
	public void search(String projectName) {
		click(searchButton);
		fillText(searchProjectField, projectName);
	}
}
