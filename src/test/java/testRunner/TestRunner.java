package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions", monochrome = true, plugin = {
		"pretty", "html:target/html-reports", "json:target/reports/cucumber.json" })
public class TestRunner extends AbstractTestNGCucumberTests {
public String browser="firefox";
//	public String env = "dev";
	// public String plan = "free";
}
