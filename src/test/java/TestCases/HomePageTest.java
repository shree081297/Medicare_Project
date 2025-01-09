package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTest extends BaseClass {
//public static ExpPrice;
	@Test(groups="regression", description="This Test cases is used to add one product to cart until invoice")
	public void addingProductCart() throws InterruptedException {
		LoginPage lp=new LoginPage(GetDriver());
		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(email);
		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(password);
		lp.EnterLoginDetails(email, password);
		lp.validateSucessMessage("Most Viewed Medicines");
		HomePage hp=new HomePage(GetDriver());
		Thread.sleep(4000);

		hp.addingOneProductToCart();
		hp.validateSucessMessage("Paracetamol");
	//	hp.addcardDetails("1234567897","12", "28", "154");
		String CardNum=sheet.getRow(1).getCell(12).getStringCellValue();
		System.out.println(CardNum);
		String Month=sheet.getRow(1).getCell(13).getStringCellValue();
		System.out.println(Month);
		String Year=sheet.getRow(1).getCell(14).getStringCellValue();
		System.out.println(Year);
		String Cvv=sheet.getRow(1).getCell(15).getStringCellValue();
		System.out.println(Cvv);
		hp.addcardDetails(CardNum, Month, Year, Cvv);
		hp.validteOrderSucessMessage("Your Order is Confirmed!!");
	
	}
	@Test(groups={"regression","sanity"})
	public void addMultipleProducts() throws InterruptedException {
		LoginPage lp=new LoginPage(GetDriver());
		String email=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(email);
		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(password);
		lp.EnterLoginDetails(email, password);
		lp.validateSucessMessage("Most Viewed Medicines");
		HomePage hp=new HomePage(GetDriver());
		Thread.sleep(4000);
		hp.addingmulProducts();
		hp.checkout();
		String CardNum=sheet.getRow(1).getCell(12).getStringCellValue();
		System.out.println(CardNum);
		String Month=sheet.getRow(1).getCell(13).getStringCellValue();
		System.out.println(Month);
		String Year=sheet.getRow(1).getCell(14).getStringCellValue();
		System.out.println(Year);
		String Cvv=sheet.getRow(1).getCell(15).getStringCellValue();
		System.out.println(Cvv);
		hp.addcardDetails(CardNum, Month, Year, Cvv);
		hp.validteOrderSucessMessage("Your Order is Confirmed!!");

		
	}
}
