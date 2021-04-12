package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public  static WebDriver driver;
    public static CommonUtils objCommonUtils;
    private String default_Properties_Path="./src/test/resources/config/default.properties";
    private final int  default_Time=20;

    //initialise a instance of required browser
    public void initializeBrowserAndOpenURL() throws Exception
    {
        if(driver==null)
        {
            String browser=  ReadProperties.getData("browser",default_Properties_Path);
            if ("IE".equalsIgnoreCase(browser))
            {
                System.setProperty("webdriver.ie.driver", "./src/test/resources/driver/IEDriverServer.exe");
                driver=new InternetExplorerDriver();
            }
            else if ("Chrome".equalsIgnoreCase(browser))
            {
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
                driver= new ChromeDriver();
            }
            else
            {
                System.setProperty("webdriver.gecko.driver", "./src/test/resources/driver/geckodriver.exe");
                driver= new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
        driver.get(ReadProperties.getData("url", default_Properties_Path));
        driver.manage().timeouts().implicitlyWait(default_Time, TimeUnit.SECONDS);
    }


    //close the driver instance
    public WebDriver closeDriver() throws Exception
    {
        objCommonUtils.takeScreenShot();
        driver.quit();
        return driver=null;
    }
}
