package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTest extends BaseClass {
//public static ExpPrice;
	@Test(groups="sanity", description="This Test cases is used to add one product to cart until invoice")
	public void addingProductCart() throws InterruptedException {
		LoginPage lp=new LoginPage(GetDriver());
		lp.EnterLoginDetails("test222@gmail.com", "Test@123");
		lp.validateSucessMessage("Most Viewed Medicines");
		HomePage hp=new HomePage(GetDriver());
		Thread.sleep(4000);

		hp.addingOneProductToCart();
		hp.validateSucessMessage("Diclofenac");
		hp.addcardDetails("1234567897","12", "28", "154");
		hp.validteOrderSucessMessage("Your Order is Confirmed!!");
	
	}
	@Test(groups={"regression","sanity"})
	public void addMultipleProducts() throws InterruptedException {
		LoginPage lp=new LoginPage(GetDriver());
		lp.EnterLoginDetails("test222@gmail.com", "Test@123");
		lp.validateSucessMessage("Most Viewed Medicines");
		HomePage hp=new HomePage(GetDriver());
		Thread.sleep(4000);
		hp.addingmulProducts();
		hp.checkout();
		hp.addcardDetails("1234567897","12", "28", "154");
		hp.validteOrderSucessMessage("Your Order is Confirmed!!");

		
	}
}
