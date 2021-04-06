package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;

public class PaymentPage extends Driver {

    private Logger logger;
    By btnPayByCheck= By.xpath( "//a[@title = 'Pay by check.']");

    public PaymentPage()
    {
        objCommonUtils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }

    //click on pay by check option
    public void clickOnPayByCheck()
    {
        objCommonUtils.clickOnWebElement(btnPayByCheck);
        logger.info("User clicked on pay by check option");
    }
}
