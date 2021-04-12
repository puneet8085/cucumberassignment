package stepdefinition;

import io.cucumber.java.en.Given;
import pages.AuthenticationPage;
import pages.HomePage;
import utils.CommonUtils;

import static org.junit.Assert.assertEquals;

public class LogInStepDef {

    HomePage homePage = new HomePage();
    CommonUtils commonUtils= new CommonUtils();
    AuthenticationPage authenticationPage = new AuthenticationPage();

    @Given("I loggedIn into application and verify page title as {string}")
    public void clickOnSignIn(String expectedTitle) throws Exception
    {
        homePage.clickOnSignIn();
        authenticationPage.enterUserName();
        authenticationPage.enterPassword();
        authenticationPage.clickOnSignInBtn();
        assertEquals(expectedTitle,commonUtils.getPageTitle());
    }


}
