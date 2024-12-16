package Pages;

import TestCases.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseClass{

	@FindBy(xpath="//a[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(id="username")
	WebElement uname;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//h3[text()='Most Viewed Medicines']")
	WebElement sucessMess;
	
	@FindBy(xpath="//div[text()='Username and Password is invalid!']")
	WebElement ErrorMessage;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void EnterLoginDetails(String un, String pwd) throws InterruptedException {
		Thread.sleep(4000);
		loginBtn.click();
		uname.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(4000);
		login.click();
		
	}
	public void validateSucessMessage(String ExpMess) {
		String actMess=sucessMess.getText();
		//Assert.assertEquals(ExpMess, actMess);
		if(actMess.equals(ExpMess)) {
			System.out.println("Message matched");
		}else {
			System.out.println("Message mismatched");
		}
	}
	public void validateErrorMessage(String ExpErrorMess) {
		String ActErrorMessage=ErrorMessage.getText();
		if(ExpErrorMess.equals(ActErrorMessage)) {
			System.out.println("Message matched");
		}else {
			System.out.println("Message mismatched");
		}
	}
	
}
