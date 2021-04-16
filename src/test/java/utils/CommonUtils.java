package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CommonUtils extends Driver {

    private final String TIMEZONE ="GMT";
    private final String DEFAULT_TIME_FORMAT ="yyyy-MM-dd_hh_mm_ss_S";

    /***
     * Click on a WebElement.
     * @param element accepts locator in By format
     */
     public void clickOnWebElement(By element)
    {
        new WebDriverWait(driver,DEFAULT_TIME).until(ExpectedConditions.visibilityOf(getWebElement(element)));
        getWebElement(element).click();
    }

    /***
     * Find a WebElement from the By locator provided
     * @param element accepts element
     * @return  element into WebElement format.
     */
    public WebElement getWebElement(By element)
    {
        new WebDriverWait(driver,DEFAULT_TIME).until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element);
    }

    /***
     * Get title of current page
     * @return Page title in String format
     */
    public String getPageTitle()
    {
        return driver.getTitle();
    }

    /***
     * Enter text based o locator provided
     * @param ele accepts element in By format
     * @param text accepts text in string format which user want ot enter inside text box
     */
    public void enterData(By ele, String text)
    {
        new WebDriverWait(driver,DEFAULT_TIME).until(ExpectedConditions.visibilityOf(getWebElement(ele)));
        WebElement element= getWebElement(ele);
        if(element.isEnabled())
         {
            element.click();
            element.sendKeys(text);
         }
     }

    /***
     * Clear text present in element based on locator provided
     * @param ele accepts element in By format
     */
    public void clearData(By ele)
    {
        new WebDriverWait(driver, DEFAULT_TIME).until(ExpectedConditions.visibilityOf(getWebElement(ele)));
        WebElement element = getWebElement(ele);
        if (!element.getText().equalsIgnoreCase(null))
        {
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
        }
    }

    /***
     * Takes screenshot and save.
     * @throws IOException on failure.
     */
    public void takeScreenShot() throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File("./screenshot/"+getDateTimeWithSec()+"screenshot.png"));
    }

    /***
     * Get current date and time with seconds.
     * @return Time in yyyy-MM-dd_hh_mm_ss_S format as a String value.
     */
    public String getDateTimeWithSec()
    {
        DateFormat df= new SimpleDateFormat(DEFAULT_TIME_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        return df.format(new Date());
    }

    /***
     * Click on a element
     * @param element1 element where user need to move first
     * @param element2 Second element at which user want to perform click operation
     */
    public void moveToWebElementAndClick(By element1, By element2)
    {
        Actions actions= new Actions(driver);
        new WebDriverWait(driver,DEFAULT_TIME).until(ExpectedConditions.visibilityOf(getWebElement(element1)));
        actions.moveToElement(objCommonUtils.getWebElement(element1)).perform();
        actions.click(objCommonUtils.getWebElement(element2)).perform();
    }

    /***
     * Click on a element using java script executor
     * @param webElement accepts element in By Format.
     */
    public void clickUsingJavaScriptExec(By webElement)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", getWebElement(webElement));
    }
}
