package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;
import utils.ReadProperties;

public class AuthenticationPage extends Driver {

    private Logger logger;
    public static String credential_Properties_Path="./src/test/resources/config/credential.properties";
    private By txtEmailAddress= By.xpath( "//input[@id='email']");
    private By txtPassword= By.xpath( "//input[@id='passwd']");
    private By btnSignIn= By.xpath( "//button[@id='SubmitLogin']");

    public AuthenticationPage()
    {
        objCommonUtils = new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }

    //enter email address
    public void enterUserName() throws Exception
    {
        objCommonUtils.enterData(txtEmailAddress, ReadProperties.getData("userName",credential_Properties_Path));
        logger.info("Username entered  successfully");
    }

    //enter Password
    public void enterPassword() throws Exception
    {
        objCommonUtils.enterData(txtPassword,ReadProperties.getData("password",credential_Properties_Path));
        logger.info("Password entered  successfully");
    }

    //click on Sign In Button
    public void clickOnSignInBtn()
    {
        objCommonUtils.clickOnWebElement(btnSignIn);
        logger.info("user clicked on signIn button");
    }
}
