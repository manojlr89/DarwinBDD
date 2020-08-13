package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions", monochrome = true, plugin = {
		"pretty", "html:target/cucumber" })
public class TestRunner {

	public String browser = "chrome";
	public String env = "dev";
	public String plan = "free";
}
