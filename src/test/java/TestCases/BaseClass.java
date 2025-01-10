package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	static ExtentReports report;
	static ExtentTest test;
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
		report = new ExtentReports("ExtantReports\\reports.html", false);

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
		report.flush();
		report.endTest(test);
	}

	@BeforeTest(alwaysRun = true)
	public void SetUpExcel() throws IOException {

		FileInputStream file = new FileInputStream("TestData\\ExcelData.xlsx");
		wbook = new XSSFWorkbook(file);
		sheet = wbook.getSheet("Sheet1");

	}

	@AfterTest(alwaysRun = true)
	public void CloseExcel() throws IOException {
		wbook.close();
	}

	public static String CaptureScreen(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File("screenshot/" + ".png");
		String absolutepath = target.getAbsolutePath();
		FileUtils.copyFile(src, target);
		return absolutepath;

	}
}
