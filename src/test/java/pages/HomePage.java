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

    //get first name value from user name present in top right corner
    public String getFirstName()
    {
        String username=objCommonUtils.getWebElement(userName).getText();
        String firstname=username.split(" ")[0];
        return firstname;
    }

    //click on Sign in Link from Menu
    public  void clickOnSignIn()
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
