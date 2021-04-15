@SmokeTest
Feature: Update user profile and place t-shirt order.

  Background: Login into application
    Given I loggedIn into application and verify page title as "My account - My Store"

  @UpdateProfile
  Scenario Outline: Updating first name of Logged In User
    When  I go to My Personal Information page
    And   I save changes by entering firstname as "<FirstName>" and current password
    Then  I see updated firstname of user next to Sign Out option
  Examples:
          |FirstName|
          |Tester   |

  @PlaceOrder
  Scenario: Ordering a t-shirt and validating order details
    When  I select a t-shirt to order
    And   Complete order by making payment
    Then  I can see placed order details in order History page
