package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyAccountPage;
import pages.PersonalInfoPage;

import static org.junit.Assert.assertEquals;
public class UpdateProfileStepDef {

    private String expected_FirstName;
    PersonalInfoPage personalInfoPage = new PersonalInfoPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    HomePage homePage=new HomePage();

    @Given("^I go to My Personal Information page$")
    public void clickOnPersonalInfoBtn()
    {
        myAccountPage.clickOnMyPersonalInfoBtn();
        assertEquals("Identity - My Store",myAccountPage.verifyPageLoad());
    }

    @When("I save changes by entering firstname as {string} and current password")
    public void enterFirstNameAndCurrentPassword(String firstname) throws Exception {
        personalInfoPage.updateFirstName(firstname);
        expected_FirstName=personalInfoPage.getExpectedFirstName();
        personalInfoPage.clickOnSaveBtn();
    }

    @Then("I see updated firstname of user next to Sign Out option")
    public void verifyUpdatedName()
    {
        assertEquals(expected_FirstName,homePage.getFirstName());
    }

}
