package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/resources/features",
	    glue="stepDefinitions",monochrome=true,
	    plugin= {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"})
public class TestRunner {
	
	public String browser = "chrome";
	public String env = "dev";

}
