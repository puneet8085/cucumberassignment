package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;
import utils.ReadProperties;

public class PersonalInfoPage extends Driver {

    private Logger logger;
    public static String lastName;
    public static String firstName;
    private By txtFirstName= By.xpath("//input[@id='firstname']");
    private By txtOldPassword= By.xpath( "//input[@id='old_passwd']");
    private By txtLastName= By.xpath("//input[@id='lastname']");
    private By btnSave= By.xpath( "//button[@name='submitIdentity']");

    public PersonalInfoPage()
    {
        objCommonUtils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }

    //enter details
    public void enterDetails(String firstname) throws Exception
    {
        objCommonUtils.enterText(txtFirstName,firstname);
        firstName=objCommonUtils.returnsWebElement(txtFirstName).getAttribute("value");
        lastName=objCommonUtils.returnsWebElement(txtLastName).getAttribute("value");
        objCommonUtils.enterText(txtOldPassword, ReadProperties.readDataFromPropertiesFile("password", AuthenticationPage.filePath));
        logger.info("user enter first name and password");
    }

    //click on Save button
    public void clickOnSaveBtn()
    {
        objCommonUtils.clickOnWebElement(btnSave);
        logger.info("User clicked on save button");
    }
}
