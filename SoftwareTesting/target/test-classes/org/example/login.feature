Feature: Saucedemo User Login

  Background:
    Given the home page is opened

  Scenario Outline: Incorrect login attempts
    Given the 'Username' field is filled with '<username>'
    And the 'Password' field is filled with '<password>'
    When the 'Login' button is clicked
    Then the '<errorMessage>' message is shown
    Examples:
      | username        | password       | errorMessage                                                              |
      |                 |                | Epic sadface: Username is required                                        |
      | standard_user   |                | Epic sadface: Password is required                                        |
      | standard_user   | wrong_password | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                       |

  Scenario Outline: Correct login attempts
    Given the 'Username' field is filled with '<username>'
    And the 'Password' field is filled with '<password>'
    When the 'Login' button is clicked
    Then the user enters "https://www.saucedemo.com/inventory.html"
    Examples:
      | username                       | password       |
      |standard_user                   | secret_sauce   |
      | problem_user                   | secret_sauce   |
      | performance_glitch_user        | secret_sauce   |
      |  error_user                    | secret_sauce   |
      | visual_user                    | secret_sauce   |


