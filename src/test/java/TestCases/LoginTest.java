package TestCases;

import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test(groups="sanity")
	public void loginWithValidCred() throws InterruptedException {
		LoginPage lp=new LoginPage(GetDriver());
//		lp.EnterLoginDetails("test222@gmail.com", "Test@123");
//		lp.validateSucessMessage("Most Viewed Medicines");
		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(email);
		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(password);
		lp.EnterLoginDetails(email, password);
		lp.validateSucessMessage("Most Viewed Medicines");
	}
	@Test(groups="invalid")
	public void loginWithInValidCred() throws InterruptedException {
		LoginPage lp=new LoginPage(GetDriver());
//		lp.EnterLoginDetails("test2@gmail.com", "Test@12");
//		lp.validateErrorMessage("Username and Password is invalid!");
		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(email);
		String InValidPwd=sheet.getRow(1).getCell(2).getStringCellValue();
		System.out.println(InValidPwd);
		lp.EnterLoginDetails(email, InValidPwd);
		lp.validateErrorMessage("Username and Password is invalid!");
	}

}
