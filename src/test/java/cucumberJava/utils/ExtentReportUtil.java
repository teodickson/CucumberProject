package cucumberJava.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.aventstack.extentreports.Status.FAIL;
import static com.aventstack.extentreports.Status.PASS;

public class ExtentReportUtil extends BaseUtil{

    String fileName = reportLocation + "extentreport.html";

    public ExtentReportUtil(WebDriver driver) {
        super(driver);
        extentReports = new ExtentReports();
    }

    public void extentReport() {

        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Extend Report Test for basic");
        spark.config().setEncoding("utf-8");
        spark.config().setReportName("Test Report 2022");

        extentReports.attachReporter(spark);
    }

    public void showStatusInReport(final Status status) {
        ExtentTest test = extentReports.createTest("My First Test");
        if(status.equals(PASS))
            test.log(PASS, "This is a logging event for MyFirstTest, and it passed!");
        else if(status.equals(FAIL))
            test.log(FAIL, "This is a logging event for MyFirstTest, and it failed!");
    }

    public void extentReportScreenshot() throws IOException {
        var screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), new File(reportLocation + "screenshot-" + System.currentTimeMillis() + ".png").toPath());
    }

    public void flushReport() {
        extentReports.flush();
    }
}
