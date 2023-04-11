package ExtentReport.Online;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MySampleExtentReport {

	ExtentReports report = new ExtentReports();
	WebDriver driver;
	String scnName;

	@BeforeTest
	public void ExtentReportDemo() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//Reports//ReportNew.html");

		reporter.config().setDocumentTitle("Sample Report Demo");
		reporter.config().setReportName("Test Case Report");
		report.attachReporter(reporter);
		report.setSystemInfo("Test", "Sample Run");
	}

	public void screenShot(String scnName) throws IOException {
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
				new File(System.getProperty("user.dir") + "Screenshot/" + scnName + ".jpeg"));
	}

	@Test
	public void sampleTest() {
		report.createTest("Create Test Sample");
		driver = new ChromeDriver(new ChromeOptions());
		driver.get("https://www.google.com");
		scnName = driver.getTitle();
		driver.close();
		report.flush();
		

	}

}
