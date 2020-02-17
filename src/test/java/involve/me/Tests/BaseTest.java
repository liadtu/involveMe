package involve.me.Tests;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;

import involve.me.PagesObjects.LogInPage;
import involve.me.PagesObjects.OrganizationSettingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;

	@BeforeClass
	public void setup(ITestContext testContext) {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-features=VizDisplayCompositor");
//		options.addArguments("--incognito");
//		options.addArguments("enable-automation"); 
//		options.addArguments("--headless"); 
//		options.addArguments("--no-sandbox"); 
//		options.addArguments("--window-size=1920,1080"); 
//		options.addArguments("--disable-gpu"); 
//		options.addArguments("--disable-extensions"); 
//		options.addArguments("--dns-prefetch-disable");
//		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		driver = new ChromeDriver(options);
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
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
