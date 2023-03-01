import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:build/cucumber-report/cucumber.json","pretty"},
features="src/test/resources/features", publish = true,
tags = "@invalid_data")
public class RunCucumberTests {
}
