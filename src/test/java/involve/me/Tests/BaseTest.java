package involve.me.Tests;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;

import involve.me.PagesObjects.LogInPage;
import involve.me.PagesObjects.OrganizationSettingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;

	@BeforeClass
	public void setup(ITestContext testContext) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		testContext.setAttribute("WebDriver", this.driver);
		driver.manage().window().maximize();
		driver.get("https://app.involve.me/login");
	}

	@BeforeClass
	public void setupLogin() {
		LogInPage loginPage = new LogInPage(driver);
		loginPage.login("liadtu@gmail.com", "Liad924799");
		OrganizationSettingPage organizationSetting = new OrganizationSettingPage(driver);
		organizationSetting.chooseOrganization("Liad");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
