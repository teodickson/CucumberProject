package cucumberJava.stepDefinition;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:feature"},
        glue = {"cucumberJava.stepDefinition"},
        //plugin = {"pretty", "html:target/cucumber-reports"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class runTest {
    //https://www.toolsqa.com/extent-report/extent-report-for-cucumber-junit-project/
}
