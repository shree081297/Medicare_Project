package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;

public class SignUpPage extends BaseClass{

	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignUpBtn;
	
	@FindBy(id="firstName")
	WebElement Firstname;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="contactNumber")
	WebElement mobile;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="confirmPassword")
	WebElement confirmpassword;
	
	@FindBy(id="role1")
	WebElement userBtn;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(id="addressLineOne")
	WebElement address1;
	
	@FindBy(id="addressLineTwo")
	WebElement address2;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="postalCode")
	WebElement pincode;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement next;
	
	@FindBy(xpath="//a[text()='Confirm']")
	WebElement confirmBtn;
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void SignupToApp(String fn, String ln,String em, String ph, String pwd, String cpwd) throws InterruptedException {
		Thread.sleep(4000);
		SignUpBtn.click();
		Firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		email.sendKeys(em);
		mobile.sendKeys(ph);
		password.sendKeys(pwd);
		confirmpassword.sendKeys(cpwd);
		userBtn.click();
		submitBtn.click();
		
	}
	public void SignUp_Address(String add1, String add2, String cty, String pin, String st, String cnty) throws InterruptedException {
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		city.sendKeys(cty);
		pincode.sendKeys(pin);
		state.sendKeys(st);
		country.sendKeys(cnty);
		next.click();
		Thread.sleep(4000);
		confirmBtn.click();
	}
	
}
