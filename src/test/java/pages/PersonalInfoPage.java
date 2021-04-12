package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.CommonUtils;
import utils.Driver;
import utils.ReadProperties;

public class PersonalInfoPage extends Driver {

    private Logger logger;
    private By txtFirstName= By.xpath("//input[@id='firstname']");
    private By txtOldPassword= By.xpath( "//input[@id='old_passwd']");
    private By txtLastName= By.xpath("//input[@id='lastname']");
    private By btnSave= By.xpath( "//button[@name='submitIdentity']");

    public PersonalInfoPage()
    {
        objCommonUtils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
    }

    //update first Name of user
    public void updateFirstName(String firstname) throws Exception
    {
        objCommonUtils.clearData(txtFirstName);
        objCommonUtils.enterData(txtFirstName,firstname);
        objCommonUtils.clearData(txtOldPassword);
        objCommonUtils.enterData(txtOldPassword, ReadProperties.getData("password", AuthenticationPage.credential_Properties_Path));
        logger.info("user enter first name and password");
    }

    //get value for first name from text box
    public String getExpectedFirstName()
    {
       String firstName=objCommonUtils.getWebElement(txtFirstName).getAttribute("value");
       return firstName;
    }

    //click on Save button
    public void clickOnSaveBtn()
    {
        objCommonUtils.clickOnWebElement(btnSave);
        logger.info("User clicked on save button");
    }
}
