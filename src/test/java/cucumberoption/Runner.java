package cucumberoption;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature",glue = "" ,
        plugin = {"json:target/jsonReports/cucumber-report.json"},
        monochrome = true,tags="@SmokeTest")


public class Runner {


}
