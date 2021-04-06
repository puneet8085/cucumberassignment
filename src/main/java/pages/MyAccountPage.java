package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;

public class MyAccountPage extends Driver {

    private Logger logger;
    By linkSignIn = By.xpath("//a[@class='login'][contains(text(),'Sign in')]");
    By menuT_Shirt = By.xpath("//div[@id='block_top_menu']/ul[1]/li[3]");
    By imgT_Shirt = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
    By btnAddToCart = By.xpath("//span[contains(text(),'Add to cart')]");
    By btnProceedToCheckOut =By.xpath("//span[contains(text(),'Proceed to checkout')]");
    By btnMyOrders =By.xpath("//a[@title='My orders']");
    By btnMyPersonalInfo =By.xpath( "//a[@title= 'Manage my personal information']");
    By userName =By.xpath("//a[@title= 'View my customer account']/span[1]");

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

    //verify updated first name
    public boolean verifyUpdatedFirstName()
    {
        if(objCommonUtils.returnsWebElement(userName).getText().equals(""+PersonalInfoPage.firstName+" "+PersonalInfoPage.lastName))
        {
            logger.info("First name matched");
            return true;
        }
        logger.info("First name not matched");
        return false;
    }

    //click on proceed to checkout button
    public void clickOnProceedToCheckout()
    {
        objCommonUtils.clickOnWebElement(btnProceedToCheckOut);
        logger.info("user clicked on proceed  to checkout button");
    }
    //click on Sign in Link from Header Menu
    public  void clickOnSignInFromMenu()
    {
        objCommonUtils.clickOnWebElement(linkSignIn);
        logger.info("user clicked in sign in from menu");
    }

    // click on T-shirt option from menu
    public void clickOnT_ShirtBtn()
    {
        objCommonUtils.clickOnWebElement(menuT_Shirt);
        logger.info("user clicked on t-shirt menu");
    }

    //click on add to cart
    public  void clickOnAddToCart()
    {
        objCommonUtils.moveToWebElementAndClick(imgT_Shirt,btnAddToCart);
        logger.info("user clicked on add to cart");
    }

    //click on my order button
    public void clickOnMyOrder()
    {
        objCommonUtils.clickOnWebElement(btnMyOrders);
        logger.info("user clicked on my order link");
    }

}
