package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class AnalyticsPage extends BasePage {

	public AnalyticsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".e-title")
	private WebElement titleOfPage;

	@Step("check the title of the page")
	public String title() {
		return getText(titleOfPage);
	}
}
