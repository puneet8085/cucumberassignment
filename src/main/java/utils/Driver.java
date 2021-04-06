package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public  static WebDriver driver;
    public static CommonUtils objCommonUtils;
    private Logger logger= Logger.getLogger(this.getClass());

    //initialise a instance of required browser
    public void initializeBrowserAndOpenURL() throws Exception {
        if(driver==null)
        {
            driver= DriverFactory.getDriver();
            driver.manage().window().maximize();
            driver.get(ReadProperties.readDataFromPropertiesFile("url", DriverFactory.filePath));
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            logger.info("Application launched successfully in browser");

        }

    }

    //close the driver instance
    public WebDriver closeDriver() throws Exception {
        ScreenshotLib.screenShot();
        driver.quit();
        logger.info("Browser Closed Successfully");
        return driver=null;

    }
}
