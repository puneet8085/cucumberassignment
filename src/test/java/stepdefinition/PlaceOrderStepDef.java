package stepdefinition;

import io.cucumber.java.en.When;
import pages.*;
import static org.junit.Assert.*;

public class PlaceOrderStepDef {

    MyAccountPage myAccountPage = new MyAccountPage();
    CartSummaryPage cartSummaryPage = new CartSummaryPage();
    AddressPage addressPage = new AddressPage();
    ShippingPage shippingPage= new ShippingPage();
    PaymentPage paymentPage = new PaymentPage();
    OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
    OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
    HomePage homePage = new HomePage();
    TShirtPage tshirtPage = new TShirtPage();

    @When("I select a t-shirt to order")
    public void clickOnOrderHistoryAndDetailsBtn()
    {
        homePage.clickOnT_ShirtBtn();
        tshirtPage.clickOnAddToCart();
    }

    @When("Complete order by making payment")
    public void completeOrder() throws InterruptedException
    {
        tshirtPage.clickOnProceedToCheckout();
        cartSummaryPage.clickOnProceedBtn();
        addressPage.clickOnProceedBtn();
        shippingPage.selectCheckbox();
        shippingPage.clickOnProceedBtn();
        paymentPage.clickOnPayByCheck();
        orderSummaryPage.clickOnConfirmOrderBtn();
        orderSummaryPage.getOrderID();
        assertNotNull("Order id is not null",OrderSummaryPage.orderRefValue);
        myAccountPage.clickOnMyOrder();
    }

}
