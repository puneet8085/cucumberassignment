package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;

public class MyAccountPage extends Driver {

    private Logger logger;
    By btnMyOrders =By.xpath("//a[@title='My orders']");
    By btnMyPersonalInfo =By.xpath( "//a[@title= 'Manage my personal information']");

    public MyAccountPage()
    {
        objCommonUtils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }

    //Get Current Page Title
    public String getPageTitle()
    {
        logger.info("Get current page title");
        return driver.getTitle();
    }

    //click on my personal info button
    public void clickOnMyPersonalInfoBtn()
    {
        objCommonUtils.clickOnWebElement(btnMyPersonalInfo);
        logger.info("user clicked on my personal info button");
    }

    //click on my order button
    public void clickOnMyOrder()
    {
        objCommonUtils.clickOnWebElement(btnMyOrders);
        logger.info("user clicked on my order link");
    }

}
