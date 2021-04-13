package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;

public class OrderSummaryPage extends Driver {

    private Logger logger;
    public static String orderRefValue;
    private By btnConfirmOrder= By.xpath("//span[contains(text(),'I confirm my order')]");
    private By orderId= By.xpath("//div[@class='box order-confirmation']");

    public OrderSummaryPage()
    {
        objCommonUtils = new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }

    //Extract order number from text
    public void getOrderID()
    {
        orderRefValue=objCommonUtils.getWebElement(orderId).getText();
        orderRefValue  = orderRefValue.substring(146,(orderRefValue.length()-214));
    }
    //click on confirm my order
    public void clickOnConfirmOrderBtn()
    {
        objCommonUtils.clickOnWebElement(btnConfirmOrder);
        logger.info("user clicked on confirm order button");
    }
}
