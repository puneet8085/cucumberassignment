package cucumberoption;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",glue = "" ,
        plugin = {"pretty","html:target/cucumber-html-reports/cucumber-reports.html"},
        monochrome = true,tags="@SmokeTest")


public class Runner {


}
