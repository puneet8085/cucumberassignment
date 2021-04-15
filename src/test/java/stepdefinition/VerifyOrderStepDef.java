package stepdefinition;

import io.cucumber.java.en.Then;
import pages.MyAccountPage;
import pages.OrderHistoryPage;
import pages.OrderSummaryPage;

import static org.junit.Assert.assertTrue;

public class VerifyOrderStepDef {

    OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
    MyAccountPage myAccountPage= new MyAccountPage();

    @Then("I can see placed order details in order History page")
    public void verifyOrder() {
        myAccountPage.clickOnMyOrder();
       assertTrue(orderHistoryPage.verifyOrderID(OrderSummaryPage.orderRefValue));
    }
}
