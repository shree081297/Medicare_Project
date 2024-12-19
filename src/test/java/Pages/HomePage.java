package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestCases.BaseClass;

public class HomePage extends BaseClass {
//	WebDriverWait wait;
//	public static String actPrice;
//	String expPrice;
	WebDriver driver;

	@FindBy(xpath="(//a[text()='View'])[2]")
	WebElement product1;
	
	@FindBy(xpath="//*[text()=' Add to Cart']")
	WebElement add;
	
//	@FindBy (xpath="//h4[@class='nomargin']")
//	WebElement Productname;
	
	@FindBy(xpath="//h3[text()='Product has been successfully added inside cart!']")
	WebElement CartMess;
	
	@FindBy(xpath="//a[text()='Checkout ']")
	WebElement checkout;
	
	@FindBy(xpath="//a[text()='Select']")
	WebElement selectbtn;
	
	@FindBy(xpath="(//div/h3)[1]")
	WebElement SucessMess;
	
	@FindBy(id="cardNumber")
	WebElement cardNum;
	
	@FindBy(id="expityMonth")
	WebElement month;
	
	@FindBy(id="expityYear")
	WebElement year;
	
	@FindBy(id="cvCode")
	WebElement cvv;
	
	@FindBy(xpath="//a[@role='button']")
	WebElement PayBtn;
	
	@FindBy(xpath="//h3[@class='text-center']")
	WebElement OrderMessage;
	/////////////////////////////////
	@FindBy(xpath="//a[text()='View Products']")
	WebElement viewProducts;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	List<WebElement> products;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void addingOneProductToCart() throws InterruptedException {
		Thread.sleep(4000);
		product1.click();
		Thread.sleep(4000);

		add.click();
		Thread.sleep(4000);

		checkout.click();
		Thread.sleep(5000);

		selectbtn.click();	
		
	}
	public void cartMessage(String ExpCartMess) {
		String actMess=CartMess.getText();
		Assert.assertEquals(actMess, ExpCartMess);
	}
	public void validateSucessMessage(String ExpMess) {
		String actualMess=SucessMess.getText();
		Assert.assertEquals(actualMess, ExpMess);
	}
	public void addcardDetails(String cd, String  mm, String yr, String cv) {
		cardNum.sendKeys(cd);
		month.sendKeys(mm);
		year.sendKeys(yr);
		cvv.sendKeys(cv);
		PayBtn.click();
		
	}
	public void validteOrderSucessMessage(String ExpOrderMess) {
		String actOrderMess=OrderMessage.getText();
		Assert.assertEquals(actOrderMess, ExpOrderMess);
		if(actOrderMess.equals(ExpOrderMess)) {
			System.out.println("Order message displayed");
		}else {
			System.out.println("Order message not displayed");
		}
	}
	public void addingmulProducts() throws InterruptedException {
		for(int i=1;i<3;i++) {
			viewProducts.click();

			Thread.sleep(4000);
			products.get(i).click();
			Thread.sleep(2000);
	//	break;
		}
	}
	public void checkout() throws InterruptedException {
		checkout.click();
		Thread.sleep(5000);

		selectbtn.click();
	}

}
