package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
//	public static WebDriver driver;
//	public static WebDriverWait wait;
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
//
//	@BeforeMethod
//	public void startTest() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8081/medicare/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		
//	}
//
//	@AfterMethod
//	public void TearDown() {
//		driver.quit();
//	}

	public static WebDriver driver;
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public static void SetDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}

	public static WebDriver GetDriver() {

		return threadLocalDriver.get();

	}

	@BeforeMethod(alwaysRun = true)
	public void SetUpDriver() throws MalformedURLException {

		String browser = System.getProperty("Browser");
		// String browser="chrome";
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("remote-chrome")) {

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setPlatform(Platform.WIN11);
			cap.setBrowserName("chrome");

			URL hub = new URL("http://localhost:4444/");
			driver = new RemoteWebDriver(hub, cap);

		} else {
			driver = new ChromeDriver();
		}
		SetDriver(driver);
		GetDriver().get("http://localhost:8081/medicare/");
		GetDriver().manage().window().maximize();
		GetDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void TearDown() {

		GetDriver().quit();
	}

	@BeforeTest(alwaysRun = true)
	public  void SetUpExcel() throws IOException {

		FileInputStream file = new FileInputStream(	"TestData\\ExcelData.xlsx");
		wbook = new XSSFWorkbook(file);
		sheet = wbook.getSheet("Sheet1");
		
	}

	@AfterTest(alwaysRun = true)
	public void CloseExcel() throws IOException {
		wbook.close();
	}

}
