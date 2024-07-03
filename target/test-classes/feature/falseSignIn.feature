

  Feature: False sign in test
    Scenario: User uses bad login credentials
      Given User goes to login page
      When User uses bad login credentials
      And User clicks login
      Then User should see popup box