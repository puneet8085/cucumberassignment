package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;

public class CartSummaryPage extends Driver
{
    private Logger logger;
    private By btnProceedToCheckOut= By.xpath("//p[@class='cart_navigation clearfix']/a[1]");

    public CartSummaryPage()
    {
        objCommonUtils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }

    //click on proceed to checkout button present in Cart Summary Page
    public void clickOnProceedBtn()
    {
        objCommonUtils.clickOnWebElement(btnProceedToCheckOut);
        logger.info("user clicked on proceed button");
    }
}
