package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.CommonUtils;
import utils.Driver;

public class ShippingPage extends Driver {

    private Logger logger;
    private By btnProceedToCheckOut = By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']/span[1]");
    private By chk_Terms = By.xpath("//input[@id='cgv']");


    public ShippingPage()
    {
        objCommonUtils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }

    //select checkbox
    public void selectCheckbox() throws InterruptedException {
        objCommonUtils.clickUsingJavaScriptExec(chk_Terms);
        logger.info("user select terms and condition checkbox");
    }

    //click on proceed to checkout
    public void clickOnProceedBtn()
    {
        objCommonUtils.clickOnWebElement(btnProceedToCheckOut);
        logger.info("user clicked on proceed button");
    }
}
