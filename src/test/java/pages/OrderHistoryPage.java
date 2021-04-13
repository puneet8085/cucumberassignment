package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinition.PlaceOrderStepDef;
import utils.CommonUtils;
import utils.Driver;

public class OrderHistoryPage extends Driver {

    private Logger logger;
    public static int existingOrderCount;
    private By orderTable = By.xpath("//table[@id='order-list']/tbody/tr");
    private By orderReference =By.xpath("//table[@id='order-list']/tbody/tr[1]/td[1]/a");

    public OrderHistoryPage() {
        objCommonUtils = new CommonUtils();
        logger = Logger.getLogger(this.getClass());
    }

    //get total no of Order from Order History page
    public int getOrderCount()
    {
        return objCommonUtils.getListOfWebElements(orderTable).size();
    }

    //verify order in order summary table
    public String getExpectedOrderID()
    {
     String expectedOrderID = null;
     if(existingOrderCount == (getOrderCount() - 1))
     {
       expectedOrderID= objCommonUtils.getWebElement(orderReference).getText();
     }
     else
     {
       new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(objCommonUtils.getWebElement(orderReference)));
       expectedOrderID= objCommonUtils.getWebElement(orderReference).getText();
     }
     return expectedOrderID;
    }
}
