package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;
import utils.Driver;

public class OrderHistoryPage extends Driver {

    private Logger logger;
    private By orderReference =By.xpath("//table[@id='order-list']/tbody/tr[1]/td[1]/a");

    public OrderHistoryPage() {
        objCommonUtils = new CommonUtils();
        logger = Logger.getLogger(this.getClass());
    }

    //verify order in order summary table
    public boolean verifyOrderID(String orderRefValue) {

      boolean flag=new WebDriverWait(driver, DEFAULT_TIME).until(ExpectedConditions.textToBe(orderReference,orderRefValue));
        return flag;

    }
}
