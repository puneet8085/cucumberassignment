package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;
import utils.Driver;

public class OrderHistoryPage extends Driver {

    private Logger logger;
    private By orderTable = By.xpath("//table[@id='order-list']/tbody/tr");
    private By orderReference =By.xpath("//table[@id='order-list']/tbody/tr[1]/td[1]/a");

    public OrderHistoryPage() {
        objCommonUtils = new CommonUtils();
        logger = Logger.getLogger(this.getClass());
    }

    //verify order in order summary table
    public boolean verifyOrderID() {

      boolean flag=new WebDriverWait(driver, 20).until(ExpectedConditions.textToBe(orderReference,OrderSummaryPage.orderRefValue));
        return flag;

    }
}
