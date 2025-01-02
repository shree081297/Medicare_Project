 package TestCases;

import org.testng.annotations.Test;

import Pages.SignUpPage;

public class SignUpTest extends BaseClass {
	
	@Test(groups="regression")
	public void SignUp() throws InterruptedException {
		SignUpPage signup=new SignUpPage(GetDriver());
		signup.SignupToApp("Test0","Test12", "test2224@gmail.com", "9999990099", "Test@123", "Test@123");
		Thread.sleep(5000);
		signup.SignUp_Address("hamaliwada","Gandhinagar","Mancherial", "12345", "Telanagana", "India");
	}

}
