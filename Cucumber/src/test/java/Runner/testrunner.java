package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features = "resource\\Login",
	glue = "Stepdefinition",
	monochrome = true, //will give console report in good format
	dryRun = false, //if this is true it will not run the test it will see if any method is missing
	strict = true, //it will chk whether any steps is not defined in the stepdefinition
	plugin = {"html:testoutput/reporthtml.html","junit:testoutput/reportjunit.xml","json:testoutput/reportjson.json"}
		
		)
public class testrunner {
	
	
	

}
