package cucumberJava.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class BaseUtil {

    public WebDriver driver;
    public ExtentReports extentReports;
    public static ExtentTest scenarioDef;
    public static ExtentTest features;
    public static String reportLocation = System.getProperty("user.dir") + "/src/main/reports/";

    public BaseUtil(WebDriver driver) {
        this.driver = driver;
    }
}
