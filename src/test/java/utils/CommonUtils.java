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
import java.util.List;
import java.util.TimeZone;

public class CommonUtils extends Driver {

    private final int  default_Time=20;
    private final String timezone="GMT";
    private final String default_TimeFormat="yyyy-MM-dd_hh_mm_ss_S";

    //Click on WebElement
    public void clickOnWebElement(By element)
    {
        new WebDriverWait(driver,default_Time).until(ExpectedConditions.visibilityOf(getWebElement(element)));
        getWebElement(element).click();
    }

    //Return single WebElement.
    public WebElement getWebElement(By element)
    {
        return driver.findElement(element);
    }

    //Returns List of WebElement
    public List<WebElement> getListOfWebElements(By element)
    {
        return driver.findElements(element);
    }

    //Get Current Page Title
    public String getPageTitle()
    {
        return driver.getTitle();
    }

    //Enter data in a text box
    public void enterData(By ele, String text)
    {
        new WebDriverWait(driver,default_Time).until(ExpectedConditions.visibilityOf(getWebElement(ele)));
        WebElement element= getWebElement(ele);
        if(element.isEnabled())
         {
            element.click();
            element.sendKeys(text);
         }
     }

     //clear text from text box
    public void clearData(By ele)
    {
        new WebDriverWait(driver, default_Time).until(ExpectedConditions.visibilityOf(getWebElement(ele)));
        WebElement element = getWebElement(ele);
        if (element.isEnabled())
        {
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
        }
    }
    public void takeScreenShot() throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File("./screenshot/"+getDateTimeWithSec()+"screenshot.png"));
    }

    //Get current date time with seconds
    public String getDateTimeWithSec()
    {
        DateFormat df= new SimpleDateFormat(default_TimeFormat);
        df.setTimeZone(TimeZone.getTimeZone(timezone));
        return df.format(new Date());
    }

    //move to a WebElement and then click on another one
    public void moveToWebElementAndClick(By moveToWebElement, By clickOnWebElement)
    {
        Actions actions= new Actions(driver);
        actions.moveToElement(objCommonUtils.getWebElement(moveToWebElement)).perform();
        actions.click(objCommonUtils.getWebElement(clickOnWebElement)).perform();
    }

    //click on webElement using JavaScriptExecutor
    public void clickUsingJavaScriptExec(By webElement)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", getWebElement(webElement));
    }
}
