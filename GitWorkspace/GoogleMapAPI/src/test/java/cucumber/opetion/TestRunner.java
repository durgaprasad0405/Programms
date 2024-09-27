package cucumber.opetion;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = "src/test/resources/GoogleMapFrature",
		plugin ={"pretty","json:target/jsonReports/cucumber-report.json"},
        glue = {"stepdef"},
        monochrome = true
		)
 //stepDefinition        stepdef
///APostMethod.feature
public class TestRunner {
	

}