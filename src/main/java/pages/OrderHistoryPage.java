package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;

public class OrderHistoryPage extends Driver {

    private Logger logger;
    private static int existingOrderCount;
    private By orderTable = By.xpath("//table[@id='order-list']/tbody/tr");
    private String orderReference = "//table[@id='order-list']/tbody/tr['%s']/td[1]/a";

    public OrderHistoryPage() {
        objCommonUtils = new CommonUtils();
        logger = Logger.getLogger(this.getClass());
    }

    //get total no of existing Order from Order History page
    public void getExistingOrderCount() {
      existingOrderCount=getOrderCount();
    }

    //get total no of Order from Order History page
    public int getOrderCount()
    {
        return objCommonUtils.returnsListOfWebElements(orderTable).size();
    }

    //verify order in order summary table
    public boolean verifyOrder() {
        int updatedOrderCount = getOrderCount();
        if (existingOrderCount== (updatedOrderCount - 1))
        {
            for (int i = 1; i <= updatedOrderCount; i++)
            {
                String orderReferenceValue = objCommonUtils.returnsDynamicWebElement(orderReference,i).getText();
                if (orderReferenceValue.equals(OrderSummaryPage.orderRefValue))
                {
                    logger.info("Order is present in order history table");
                    return true;
                }
            }
        }

        logger.info("order not present in order history table");
        return false;
    }
}
