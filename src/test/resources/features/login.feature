Feature: Login & authorisation

  #Background:
  #Given user test@gmail.com is registered with test@gmail.com password
  @valid_data
  Scenario: Login with correct data and existing user
    Given navigate to Phone book root path
    And Enter valid username and password
    And Click on login button
    Then SignOut button is shown

  @invalid_data
  Scenario Outline: Login with invalid credentials
    Given navigate to Phone book root path
    When enter invalid creds
    | email   | password   |
    | <email> | <password> |
    And Click on login button
    Then error message is shown
    Examples:
    | email            | password       |
    | kjfkdm@gmail.com | test@gmail.com |
    | test@gmail.com   | wqkmqwi22i     |


  Scenario Outline: Login with invalid credentials (option 2)
    Given navigate to Phone book root path
    When we enter <email> and <password> as invalid data
    And Click on login button
    Then error message is shown
    Examples:
      | email            | password       |
      | kjfkdm@gmail.com | test@gmail.com |
      | test@gmail.com   | wqkmqwi22i     |


  Scenario: Login with invalid credentials (option 3)
    Given navigate to Phone book root path
    When we enter kjfkdm@gmail.com and test@gmail.com as invalid data
    And Click on login button
    Then error message is shown