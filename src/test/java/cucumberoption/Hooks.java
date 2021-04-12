package cucumberoption;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.PropertyConfigurator;
import utils.Driver;

public class Hooks {

    Driver driver= new Driver();

    @Before
    public void LaunchBrowser() throws Exception
    {
        PropertyConfigurator.configure("./src/test/resources/config/log4j.properties");
        driver.initializeBrowserAndOpenURL();
    }

    @After
    public void teardown() throws Exception
    {
        driver.closeDriver();
    }
}
