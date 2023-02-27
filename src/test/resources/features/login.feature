Feature: Login & authorisation

  #Background:
  #Given user test@gmail.com is registered with test@gmail.com password

  Scenario: Login with correct data and existing user
    Given navigate to Phone book root path
    And Enter valid username and password
    And Click on login button
    Then SignOut button is shown