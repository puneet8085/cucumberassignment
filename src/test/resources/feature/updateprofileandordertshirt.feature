Feature: Update user profile and place t-shirt order.

  Background: Login into application
    Given I loggedIn into application and verify page title as "My account - My Store"

  @SmokeTest
  Scenario: Updating first name of Logged In User
    When  I go to My Personal Information page
    And   I click on Save after entering firstname as "Tester" and current password
    Then  I can see updated firstname of user next to Sign Out option

  @SmokeTest
  Scenario: Ordering a t-shirt and validating order details
    When  I select a t-shirt to order
    And   Complete order by making payment
    Then  I can see placed order details in order History page
