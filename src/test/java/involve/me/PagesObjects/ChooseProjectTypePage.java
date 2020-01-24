package involve.me.PagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ChooseProjectTypePage extends BasePage {

	@FindBy(css = ".content-type.blank")
	private WebElement startFromScratchButton;

	public ChooseProjectTypePage(WebDriver driver) {
		super(driver);
	}

	@Step("click start From Scratch Button")
	public void blankProject() {
		click(startFromScratchButton);
	}

}
