package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CommonUtils extends Driver {

    Actions actions= new Actions(driver);

    //Clicks on WebElement
    public void clickOnWebElement(By element)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(returnsWebElement(element)));
        returnsWebElement(element).click();
    }

    //Return single WebElement.
    public WebElement returnsWebElement(By element)
    {
        return driver.findElement(element);
    }

    //Returns List of WebElement
    public List<WebElement> returnsListOfWebElements(By element)
    {
        return driver.findElements(element);
    }

    //Returns a WebElement which is dynamic in nature.
    public WebElement returnsDynamicWebElement(String element, int value)
    {
        return driver.findElement(By.xpath(String.format(element, value)));
    }

    //Enters text in a WebElement
    public void enterText(By ele,String text)
    {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(returnsWebElement(ele)));
        WebElement element=returnsWebElement(ele);
        if(element.isEnabled())
         {
            element.click();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
         }
     }

    //Get current date time with seconds
    public final static String getDateTimeWithSec()
    {
        DateFormat df= new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_S");
        df.setTimeZone(TimeZone.getTimeZone("GNT"));
        return df.format(new Date());
    }

    //move to a WebElement and then click on another one
    public void moveToWebElementAndClick(By moveToWebElement, By clickOnWebElement)
    {
        actions.moveToElement(objCommonUtils.returnsWebElement(moveToWebElement)).perform();
        actions.click(objCommonUtils.returnsWebElement(clickOnWebElement)).perform();
    }

    //click on webElement using JavaScriptExecutor
    public void clickUsingJavaScriptExec(By webElement)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", returnsWebElement(webElement));
    }
}
