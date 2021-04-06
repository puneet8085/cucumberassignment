package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;

public class TShirtPage extends Driver {

    private Logger logger;
    By imgT_Shirt = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
    By btnAddToCart = By.xpath("//span[contains(text(),'Add to cart')]");
    By btnProceedToCheckOut =By.xpath("//span[contains(text(),'Proceed to checkout')]");

    public TShirtPage()
    {
        objCommonUtils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }
    //click on proceed to checkout button
    public void clickOnProceedToCheckout()
    {
        objCommonUtils.clickOnWebElement(btnProceedToCheckOut);
        logger.info("user clicked on proceed  to checkout button");
    }

    //click on add to cart
    public  void clickOnAddToCart()
    {
        objCommonUtils.moveToWebElementAndClick(imgT_Shirt,btnAddToCart);
        logger.info("user clicked on add to cart");
    }

}
