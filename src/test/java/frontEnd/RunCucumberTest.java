package frontEnd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:json/cucumber.json"}, features = "src/test/resources")
public class RunCucumberTest{
}
