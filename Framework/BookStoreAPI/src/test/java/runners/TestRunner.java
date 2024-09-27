package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests/End2End_Test.feature",
        plugin ={"pretty","json:target/jsonReports/cucumber-report.json"},
        glue = {"stepsDefinitions"},
        monochrome = true
     
)

public class TestRunner {

}