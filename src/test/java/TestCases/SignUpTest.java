package TestCases;

import org.testng.annotations.Test;

import Pages.SignUpPage;

public class SignUpTest extends BaseClass {
	
	@Test(groups="smoke")
	public void SignUp() throws InterruptedException {
		SignUpPage signup=new SignUpPage(GetDriver());
//		signup.SignupToApp("Test2","Test1", "test222@gmail.com", "99999999", "Test@123", "Test@123");
//		signup.SignUp_Address("hamaliwada","Gandhinagar","Mancherial", "12345", "Telanagana", "India");
		String FirstName=sheet.getRow(1).getCell(3).getStringCellValue();
		System.out.println(FirstName);
		String Lastname=sheet.getRow(1).getCell(4).getStringCellValue();
		System.out.println(Lastname);
		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(email);
		String mobile=sheet.getRow(1).getCell(5).getStringCellValue();
		System.out.println(mobile);
		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(password);
		String confirmPassword=sheet.getRow(1).getCell(6).getStringCellValue();
		System.out.println(confirmPassword);
		signup.SignupToApp(FirstName, Lastname, email, mobile, password, confirmPassword);
		
		signup.validateSuccessMess("Sign Up - Address");
		
		String Address1=sheet.getRow(1).getCell(7).getStringCellValue();
		System.out.println(Address1);
		String Address2=sheet.getRow(1).getCell(8).getStringCellValue();
		System.out.println(Address2);
		String city=sheet.getRow(1).getCell(9).getStringCellValue();
		System.out.println(city);
		String pin=sheet.getRow(1).getCell(10).getStringCellValue();
		System.out.println(pin);
		String state=sheet.getRow(1).getCell(11).getStringCellValue();
		System.out.println(state);
		String country=sheet.getRow(1).getCell(12).getStringCellValue();
		System.out.println(country);
		signup.SignUp_Address(Address1, Address2, city, pin, state, country);
		signup.validateLoginMess("You can use your email address as username to login!");
		
		
		
		
	}

}
