Feature: Saucedemo being redirected to other websites

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked

  Scenario: Going to Saucedemo Twitter page
    Given the 'Twitter' button is clicked
    Then the user gets redirected to 'https://x.com/saucelabs?mx=2'

  Scenario: Going to Saucedemo Facebook page
    Given the 'Facebook' button is clicked
    Then the user gets redirected to 'https://www.facebook.com/saucelabs'

  Scenario: Going to Saucedemo LinkedIn page
    Given the 'LinkedIn' button is clicked
    Then the user gets redirected to 'https://www.linkedin.com/company/sauce-labs/'

  Scenario: Going to the About page
    Given the 'Menu' button is clicked
    Then the 'About' button is clicked
    Then the user enters 'https://saucelabs.com/'