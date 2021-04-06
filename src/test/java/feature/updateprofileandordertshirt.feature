Feature: Update user profile and place t-shirt order.

  Background: Login into application
    Given I click on Sign In button from menu
    When  I  enter username and password present in credential file  and click SignIn
    Then  I can see page title as "My account - My Store"


  @SmokeTest
  Scenario: Updating first name of Logged In User

    Given I click on My Personal Information button
    And   Enter firstname as "Tester" and current password
    When  I click on Save Button
    Then  I can see updated firstname of user next to Sign Out option

  @SmokeTest
  Scenario: Ordering a t-shirt and validating order details

    Given I click on Order History and Details button
    And   I fetch total no. of existing orders
    When  I go to T-shirt page
    And   Add a T-shirt into cart and click on proceed
    And   Click on proceed to checkout from summary tab
    And   Complete order by making payment
    And   I click on Order History and Details button
    Then  I can see placed order details in order History page
