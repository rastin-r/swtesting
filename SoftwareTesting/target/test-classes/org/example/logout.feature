Feature: Saucedemo User Logout

  Background:
    Given the home page is opened


  Scenario Outline: User can log out successfully after logging in
    Given the 'Username' field is filled with '<username>'
    And the 'Password' field is filled with '<password>'
    When the 'Login' button is clicked
    When the 'Menu' button is clicked
    When the 'Logout' button is clicked
    Then the user enters "https://www.saucedemo.com/"
    Examples:
      | username                       | password       |
      |standard_user                   | secret_sauce   |
      | problem_user                   | secret_sauce   |
      | performance_glitch_user        | secret_sauce   |
      |  error_user                    | secret_sauce   |
      | visual_user                    | secret_sauce   |