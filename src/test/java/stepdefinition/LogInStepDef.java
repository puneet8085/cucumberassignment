package stepdefinition;

import io.cucumber.java.en.Given;
import pages.AuthenticationPage;
import pages.HomePage;
import utils.CommonUtils;
import static org.junit.Assert.assertEquals;

public class LogInStepDef {

    private String expectedPageTitle="Login - My Store";
    HomePage homePage = new HomePage();
    CommonUtils objCommonUtils= new CommonUtils();
    AuthenticationPage authenticationPage = new AuthenticationPage();

    @Given("I loggedIn into application and verify page title as {string}")
    public void clickOnSignIn(String expectedTitle) throws Exception
    {
        homePage.clickOnSignIn();
        assertEquals(expectedPageTitle,homePage.verifyPageTitle());
        authenticationPage.enterUserName();
        authenticationPage.enterPassword();
        authenticationPage.clickOnSignInBtn();
        assertEquals(expectedTitle,objCommonUtils.getPageTitle());
    }


}
