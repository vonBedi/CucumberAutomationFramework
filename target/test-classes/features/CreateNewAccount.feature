Feature: Create a new account
  In order to add products to shopping cart
  As a MyStore app user
  I want to create a new MyStore account

  Scenario: No user is currently signed in
    Given MyStore main page is loaded in foreground
    When Sign in button is pressed
    And A valid email address is entered in the Create an account section
    And Create an account button is pressed
    And Personal Information, Address and Contact info fields are filled in with valid data
    And Register button is pressed
    Then A new account with previously entered data is created