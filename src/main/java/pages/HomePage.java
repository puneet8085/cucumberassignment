package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;

public class HomePage extends Driver {

    private Logger logger;
    private By linkSignIn = By.xpath("//a[@class='login'][contains(text(),'Sign in')]");
    private By menuT_Shirt = By.xpath("//div[@id='block_top_menu']/ul[1]/li[3]");
    private By userName =By.xpath("//a[@title= 'View my customer account']/span[1]");

    public HomePage()
    {
        objCommonUtils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
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

    //click on Sign in Link from Menu
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

}
