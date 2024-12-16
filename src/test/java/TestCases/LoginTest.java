package TestCases;

import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test
	public void loginWithValidCred() throws InterruptedException {
		LoginPage lp=new LoginPage();
		lp.EnterLoginDetails("test222@gmail.com", "Test@123");
		lp.validateSucessMessage("Most Viewed Medicines");
	}
	@Test
	public void loginWithInValidCred() throws InterruptedException {
		LoginPage lp=new LoginPage();
		lp.EnterLoginDetails("test2@gmail.com", "Test@12");
		lp.validateErrorMessage("Username and Password is invalid!");
	}

}
