package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthenticationPage;
import pages.MyAccountPage;

import static org.junit.Assert.assertEquals;

public class LogInStepDef {

    MyAccountPage myAccountPage = new MyAccountPage();
    AuthenticationPage authenticationPage = new AuthenticationPage();

    @Given("I click on Sign In button from menu")
    public void clickOnSignIn() throws Exception {
        myAccountPage.clickOnSignInFromMenu();

    }

    @When("I  enter username and password present in credential file  and click SignIn")
    public void enterCredentials() throws Exception {
        authenticationPage.enterUserName();
        authenticationPage.enterPassword();authenticationPage.clickOnSignInBtn();

    }
    @Then("I can see page title as {string}")
    public void enterFirstNameAndCurrentPassword(String expectedTitle) throws Exception
    {
        assertEquals(expectedTitle,myAccountPage.getPageTitle());
    }
}
