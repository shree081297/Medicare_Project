package TestCases;

import org.testng.annotations.Test;

import Pages.SignUpPage;

public class SignUpTest extends BaseClass {
	
	@Test
	public void SignUp() throws InterruptedException {
		SignUpPage signup=new SignUpPage(GetDriver());
		signup.SignupToApp("Test2","Test1", "test222@gmail.com", "99999999", "Test@123", "Test@123");
		signup.SignUp_Address("hamaliwada","Gandhinagar","Mancherial", "12345", "Telanagana", "India");
	}

}
