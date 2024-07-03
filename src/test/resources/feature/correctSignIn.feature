

  Feature:User uses correct credentials
    Scenario:User uses correct credentials
      Given User goes to signin page
      When User uses good login credentials
      And User clicks login button
      Then User sees popup box