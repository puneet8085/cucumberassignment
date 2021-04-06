package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.*;

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

    @Given("I click on Order History and Details button")
    public void clickOnOrderHistoryAndDetailsBtn()
    {
        myAccountPage.clickOnMyOrder();
    }

    @Given("I fetch total no. of existing orders")
    public void getTotalOrderCount()
    {
       orderHistoryPage.getExistingOrderCount();
    }

    @When("I go to T-shirt page")
    public void clickOnT_shirtMenu()
    {
        homePage.clickOnT_ShirtBtn();
    }

    @When("Add a T-shirt into cart and click on proceed")
    public void addT_Shirt()
    {
        tshirtPage.clickOnAddToCart();
        tshirtPage.clickOnProceedToCheckout();
    }

    @When("Click on proceed to checkout from summary tab")
    public void clickOnProceedToCheckout()  {
        cartSummaryPage.clickOnProceedBtn();
    }

    @When("Complete order by making payment")
    public void completeOrder() throws InterruptedException
    {
        addressPage.clickOnProceedBtn();
        shippingPage.selectCheckbox();
        shippingPage.clickOnProceedBtn();
        paymentPage.clickOnPayByCheck();
        orderSummaryPage.clickOnConfirmOrderBtn();
        orderSummaryPage.getOrderID();
    }

}
