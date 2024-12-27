Feature: Sort Products
  As a user
  I want to sort products by price from high to low
  So that I can see the most expensive products first

  Scenario: Successful sorting by high to low
    Given User is logged in with username "standard_user" and password "secret_sauce"
    When User sorts the products by "Price (high to low)"
    Then The product list should be sorted by price in descending order
    And Close the browser
