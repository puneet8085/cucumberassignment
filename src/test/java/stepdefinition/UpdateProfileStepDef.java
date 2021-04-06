package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyAccountPage;
import pages.PersonalInfoPage;
import static org.junit.Assert.assertTrue;

public class UpdateProfileStepDef {

    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Given("^I click on My Personal Information button$")
    public void clickOnPersonalInfoBtn() throws Throwable {
        myAccountPage.clickOnMyPersonalInfoBtn();
    }

    @When("Enter firstname as {string} and current password")
    public void enterFirstNameAndCurrentPassword(String firstname) throws Exception {
        personalInfoPage.enterDetails(firstname);
    }
    @When("I click on Save Button")
    public void clickOnSaveBtn() {
        personalInfoPage.clickOnSaveBtn();

    }
    @Then("I can see updated firstname of user next to Sign Out option")
    public void verifyUpdatedName() {
       assertTrue(myAccountPage.verifyUpdatedFirstName());
    }

}
