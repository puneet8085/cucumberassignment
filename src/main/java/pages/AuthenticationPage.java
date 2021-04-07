package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;
import utils.ReadProperties;

public class AuthenticationPage extends Driver {

    private Logger logger;
    public static String filePath="./src/main/java/config/credential.properties";
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
        objCommonUtils.enterText(txtEmailAddress, ReadProperties.readDataFromPropertiesFile("userName",filePath));
        logger.info("Username entered  successfully");
    }

    //enter Password
    public void enterPassword() throws Exception
    {
        objCommonUtils.enterText(txtPassword,ReadProperties.readDataFromPropertiesFile("password",filePath));
        logger.info("Password entered  successfully");
    }

    //click on Sign In Button
    public void clickOnSignInBtn()
    {
        objCommonUtils.clickOnWebElement(btnSignIn);
        logger.info("user clicked on signIn button");
    }
}
