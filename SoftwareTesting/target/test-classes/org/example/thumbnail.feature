Feature: Verify product thumbnails are displayed correctly

  Scenario: Ensuring all product thumbnails are displayed on the inventory page
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked
    Then all product thumbnails should be visible
