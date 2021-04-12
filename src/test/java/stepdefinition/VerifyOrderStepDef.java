package stepdefinition;

import io.cucumber.java.en.Then;
import pages.OrderHistoryPage;
import pages.OrderSummaryPage;
import static org.junit.Assert.assertEquals;

public class VerifyOrderStepDef {

    OrderHistoryPage orderHistoryPage = new OrderHistoryPage();

    @Then("I can see placed order details in order History page")
    public void verifyOrder() {
       assertEquals(orderHistoryPage.getExpectedOrderID(), OrderSummaryPage.orderRefValue);
    }
}
