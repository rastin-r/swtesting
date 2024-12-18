Feature: Saucedemo Shopping

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked

  Scenario Outline: Verifying price of item during checkout
    Given the '<Product>' is added to the cart
    And the 'Cart' button is clicked
    And the 'Checkout' button is clicked
    And the 'First Name' field is filled with 'John'
    And the 'Last Name' field is filled with 'Doe'
    And the 'Zip Code' field is filled with '3210'
    When the 'Continue' button is clicked
    Then the price should read '<Price>'
    And the 'Finish' button is clicked

    Examples:
      | Product                           | Price |
      | Sauce Labs Backpack               |Total: $32.39|
      | Sauce Labs Bike Light             |Total: $10.79|
      | Sauce Labs Bolt T-Shirt           |Total: $17.27|
      | Sauce Labs Fleece Jacket          |Total: $53.99|
      | Sauce Labs Onesie                 |Total: $8.63|
      | Test.allTheThings() T-Shirt (Red) |Total: $17.27|


  Scenario Outline: Incorrect checking out
    Given the 'Sauce Labs Bolt T-Shirt' is added to the cart
    And the 'Cart' button is clicked
    And the 'Checkout' button is clicked
    And the 'First Name' field is filled with '<firstname>'
    And the 'Last Name' field is filled with '<lastname>'
    And the 'Zip Code' field is filled with '<zipcode>'
    When the 'Continue' button is clicked
    Then the checkout error '<checkoutErrorMessage>' is shown
    And the shopping cart must be emptied

    Examples:
      | firstname | lastname | zipcode | checkoutErrorMessage           |
      |           |          |         | Error: First Name is required  |
      | John      |          | 3210    | Error: Last Name is required   |
      | John      | Doe      |         | Error: Postal Code is required |
      |           | Doe      | 3210    | Error: First Name is required  |
      |           |          | 3210    | Error: First Name is required  |
      |           | Doe      |         | Error: First Name is required  |



  Scenario: Reset App State
    Given the 'Menu' button is clicked
    And the 'Reset' button is clicked
    Then the shopping cart must be emptied



