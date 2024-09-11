Feature: User Management

  Scenario: Add a new user and validate
    Given I am on the user management page
    When I add a user with username "shareef"
    Then The user with username "shareef" should be present in the table

  Scenario: Delete an existing user and validate
    Given I am on the user management page
    When I delete the user with username "novak"
    Then The user with username "novak" should not be present in the table
