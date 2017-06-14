Feature: Login feature

  Scenario: Upon launch, all elements of the login page should appear correctly
    Then I see the twitter button
    Then I see the facebook button
    Then I press the facebook button
    Then I see facebook's web view
    Then I see facebook's email field
    Then I see facebook's password field
    Then I see facebook's login button

