package cucumberoption;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {

    Driver driver= new Driver();

    @Before
    public void LaunchBrowser() throws Exception
    {
        driver.initializeBrowserAndOpenURL();
    }

    @After
    public void teardown() throws Exception
    {
        driver.closeDriver();
    }
}
