package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test(groups="sanity")
	public void loginWithValidCred() throws InterruptedException, IOException {
		try {
			test = report.startTest("Tc_001").assignAuthor("Srikanth").assignCategory("sanity testing");

		LoginPage lp=new LoginPage(GetDriver());
//		lp.EnterLoginDetails("test222@gmail.com", "Test@123");
//		lp.validateSucessMessage("Most Viewed Medicines");
		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(email);
		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(password);
		lp.EnterLoginDetails(email, password);
		lp.validateSucessMessage("Most Viewed Medicines");
		test.log(LogStatus.PASS, "User sucessfully logged in to the application user landed on Homepage");
	}catch(Exception e) {
		test.log(LogStatus.FAIL,test.addScreenCapture(CaptureScreen(driver))+"User unable to logged in to the application","User failed to logged in to the application");
	}
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
