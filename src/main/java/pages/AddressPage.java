package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;

public class AddressPage extends Driver {

    private Logger logger;
    private By btnProceedToCheckOut= By.xpath("//button[@class='button btn btn-default button-medium']/span[1]");

    public AddressPage()
    {
        objCommonUtils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }

    //click on proceed to checkout button present in Address page
    public void clickOnProceedBtn()
    {
        objCommonUtils.clickOnWebElement(btnProceedToCheckOut);
        logger.info("user clicked on proceed button");
    }
}
