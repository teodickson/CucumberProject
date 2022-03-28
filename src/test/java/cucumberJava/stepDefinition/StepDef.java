package cucumberJava.stepDefinition;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
import com.aventstack.extentreports.Status;
import cucumberJava.utils.ExtentReportUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class StepDef {
    WebDriver driver;
    ExtentReportUtil extent;

    @Before
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        extent = new ExtentReportUtil(driver);
        extent.extentReport();
        System.out.println("Run this first ...");
    }

    @Given("^I have opened the browser \"([^\"]*)\"$") // "([^"]*)"
    public void iHaveOpenBrowser(String name) {
        driver.manage().window().fullscreen();
        System.out.println("The browser is " + name);
    }

    @Then("^I open Facebook website$")
    public void iOpenFacebookWebsite() {
        driver.get("http://www.facebook.com");
    }

    @Then("^Login button should exit$")
    public void loginButton() {
        if(driver.findElement(By.name("login")).isEnabled()) {
            System.out.println("Test 1 Pass");
            extent.showStatusInReport(Status.PASS);
        } else {
            System.out.println("Test 1 Fail");
            extent.showStatusInReport(Status.FAIL);
        }
    }

    @After
    public void afterTest() throws IOException {
        extent.extentReportScreenshot();
        extent.flushReport();
        driver.close();
        driver.quit();
    }
}
