Feature: Login functionality
  As a user
  I want to be able to log in to the application
  So that I can access the features of the application

  Scenario: Successful login
    Given User is on the login page
    When User enters valid username "standard_user" and password "secret_sauce"
    Then User should see the home page with title "Swag Labs"
    Then Close the browser

  Scenario: Failed login with invalid credentials
    Given User is on the login page
    When User enters invalid username "test" and password "test"
    Then User should see an error message "Epic sadface: Username and password do not match any user in this service"
    Then Close the browser
