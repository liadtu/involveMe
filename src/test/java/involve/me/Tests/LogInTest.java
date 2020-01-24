package involve.me.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import involve.me.PagesObjects.LogInPage;
import involve.me.PagesObjects.MainPage;
import involve.me.PagesObjects.ResetYourPasswordPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LogInTest extends BaseTest {
	
	@Severity(SeverityLevel.NORMAL)
	@Description("type valid values in email and password fields in login page")
	@Test(description = "login success")
	public void t_01logInSuccess() {
		MainPage mainPage = new MainPage(driver);
		String expected = mainPage.accountName();
		System.out.println(expected);
		Assert.assertEquals("Liad", expected);
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("type unvalid values in email and password fields in login page")
	@Test(description = "login faild")
	public void t_02logInFaild() {
		MainPage MainPage = new MainPage(driver);
		MainPage.logOut("Log Out");
		LogInPage loginPage = new LogInPage(driver);
		loginPage.login("v@gmail.com", "1234");
		String expected = loginPage.errLogIn();
		System.out.println(expected);
		Assert.assertEquals("These credentials do not match our records.", expected);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("click forgot password and check that get error message after type unvalid email")
	@Test(description = "reset password faild")
	public void t_03resetPassFaild() {
		LogInPage loginPage = new LogInPage(driver);
		loginPage.forgotPassword();
		ResetYourPasswordPage resetYourPassword = new ResetYourPasswordPage(driver);
		resetYourPassword.resetPassword("bla@gmail.com");
		String expected = resetYourPassword.errorResetPassMessage();
		Assert.assertEquals("We can't find a user with that e-mail address.", expected);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("click forgot password and check that get success message after type valid email")
	@Test(description = "reset password Success")
	public void t_04resetPassFaild() {
		ResetYourPasswordPage resetYourPassword = new ResetYourPasswordPage(driver);
		resetYourPassword.resetPassword("liadtu@gmail.com");
		String expected = resetYourPassword.resetPassSuccessMessage();
		Assert.assertEquals("A reset link has been sent to the email address, if it has been used to register for an account.", expected);
	}

}
