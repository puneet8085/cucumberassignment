package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

    public  static WebDriver driver;
    public static CommonUtils objCommonUtils;
    private final String DEFAULT_PROPERTIES_PATH="./src/test/resources/config/default.properties";
    public static final String CREDENTIAL_PROPERTIES_PATH ="./src/test/resources/config/credential.properties";
    public final int DEFAULT_TIME =20;
    private final String Driver_EXE_PATH="/src/test/resources/driver";

    /***
     * Maximize initialised browser window and open application URL.
     * @throws Exception throws Exception on failure.
     */
    public void openApplication() throws Exception
    {
        driver=getDriver();
        driver.manage().window().maximize();
        driver.get(ReadProperties.getData("url", DEFAULT_PROPERTIES_PATH));
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIME, TimeUnit.SECONDS);
    }

    /***
     * Initialise browser.
     * @return instance of browser based on browser name provided.
     * @throws Exception on failure.
     */
    public WebDriver getDriver() throws Exception {
        if(driver==null)
        {
            String browser=  ReadProperties.getData("browser",DEFAULT_PROPERTIES_PATH);
            if (browser.equalsIgnoreCase("IE"))
            {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+Driver_EXE_PATH+"/IEDriverServer.exe");
                driver=new InternetExplorerDriver();
            }
            else if (browser.equalsIgnoreCase("Chrome"))
            {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+Driver_EXE_PATH+"/chromedriver.exe");
                driver= new ChromeDriver();
            }
            else
            {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+Driver_EXE_PATH+"/geckodriver.exe");
                driver= new FirefoxDriver();
            }
        }
        return driver;
    }


    /***
     * Take screenshot of browser window and to close all open browser window.
     * @return driver value as null.
     * @throws Exception on failure
     */
    public WebDriver closeDriver() throws Exception
    {
        objCommonUtils.takeScreenShot();
        driver.quit();
        return driver=null;
    }
}
