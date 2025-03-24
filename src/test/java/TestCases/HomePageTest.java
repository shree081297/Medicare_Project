package TestCases;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import Pages.LoginPage;
	//shree
public class HomePageTest extends BaseClass {
//public static ExpPrice;
	@Test(groups = "regression", description = "This Test cases is used to add one product to cart until invoice")
	public void addingProductCart() throws InterruptedException, IOException {
		try {
			test = report.startTest("TC_004").assignAuthor("srikanth").assignCategory("regression testing");
			LoginPage lp = new LoginPage(GetDriver());
			String email = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(email);
			String password = sheet.getRow(1).getCell(1).getStringCellValue();
			System.out.println(password);
			lp.EnterLoginDetails(email, password);
			lp.validateSucessMessage("Most Viewed Medicines");
			HomePage hp = new HomePage(GetDriver());
			Thread.sleep(4000);

			hp.addingOneProductToCart();
			hp.validateSucessMessage("Paracetamol");
			// hp.addcardDetails("1234567897","12", "28", "154");
			String CardNum = sheet.getRow(1).getCell(12).getStringCellValue();
			System.out.println(CardNum);
			String Month = sheet.getRow(1).getCell(13).getStringCellValue();
			System.out.println(Month);
			String Year = sheet.getRow(1).getCell(14).getStringCellValue();
			System.out.println(Year);
			String Cvv = sheet.getRow(1).getCell(15).getStringCellValue();
			System.out.println(Cvv);
			hp.addcardDetails(CardNum, Month, Year, Cvv);
			hp.validteOrderSucessMessage("Your Order is Confirmed!!");
			test.log(LogStatus.PASS, "user navigated to all fields until invoice",
					"user sucessfully added a product until invoice");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(CaptureScreen(driver)) + "user faield to add product to cart");
			Assert.fail();
		}
	}

	@Test(groups = { "regression1", "sanity" })
	public void addMultipleProducts() throws InterruptedException, IOException {
		try {
			test = report.startTest("TC_005").assignAuthor("srikanth").assignCategory("regression testing");

			LoginPage lp = new LoginPage(GetDriver());
			String email = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(email);
			String password = sheet.getRow(1).getCell(1).getStringCellValue();
			System.out.println(password);
			lp.EnterLoginDetails(email, password);
			lp.validateSucessMessage("Most Viewed Medicines");
			HomePage hp = new HomePage(GetDriver());
			Thread.sleep(4000);
			hp.addingmulProducts();
			hp.checkout();
			String CardNum = sheet.getRow(1).getCell(12).getStringCellValue();
			System.out.println(CardNum);
			String Month = sheet.getRow(1).getCell(13).getStringCellValue();
			System.out.println(Month);
			String Year = sheet.getRow(1).getCell(14).getStringCellValue();
			System.out.println(Year);
			String Cvv = sheet.getRow(1).getCell(15).getStringCellValue();
			System.out.println(Cvv);
			hp.addcardDetails(CardNum, Month, Year, Cvv);
			hp.validteOrderSucessMessage("Your Order is Confirmed!!");
			test.log(LogStatus.PASS, "user navigated to all fields until invoice",
					"user sucessfully added multiple product until invoice");

		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(CaptureScreen(driver)) + "user faield to add product to cart");
			Assert.fail();
		}

	}
}
