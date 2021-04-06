package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

  public static String filePath="./src/main/java/config/default.properties";

    public static WebDriver getDriver() throws Exception {

      String browser=  ReadProperties.readDataFromPropertiesFile("browser",filePath);
        if ("IE".equals(browser)) {
            System.setProperty("webdriver.ie.driver", "./src/main/java/driver/IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else if ("Chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "./src/main/java/driver/chromedriver.exe");
            return new ChromeDriver();
        }
        System.setProperty("webdriver.gecko.driver", "./src/main/java/driver/geckodriver.exe");
        return new FirefoxDriver();
    }}


