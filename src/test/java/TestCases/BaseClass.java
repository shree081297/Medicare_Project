package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	@BeforeMethod
	public void startTest() {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8081/medicare/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
