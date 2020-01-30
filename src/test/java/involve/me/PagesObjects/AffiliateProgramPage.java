package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class AffiliateProgramPage extends BasePage {

	public AffiliateProgramPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".e-title")
	private WebElement titlePage;

	@Step("check title of the page")
	public String title() {
		return getText(titlePage);
	}

}
