Feature: Checkout Product
  As a user
  I want to add products to the cart and checkout successfully
  So that I can confirm my purchase

  Scenario: Successful checkout
    Given User is logged in with username "standard_user" and password "secret_sauce"
    When User adds two products to the cart
    And User completes checkout with first name "Lilas", last name "Ikuta", and postal code "11270"
    Then User should see the confirmation message "Thank you for your order!"
    And Close the browser
