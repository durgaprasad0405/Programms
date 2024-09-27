package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests/End2End_Test.feature",
        plugin ={"pretty","json:target/jsonReports/cucumber-report.json"},
        glue = {"stepDefinitions"},
        monochrome = true
     
        //functionalTests/End2End_Test.feature
        //MapAPIFunctional/PostMethod.feature
        //TestingFile/PosAndNeg.feature
        //MapsAPI/PostMehtodAPI.feature
        //Steps			maps
        
)

public class TestRunner {

}