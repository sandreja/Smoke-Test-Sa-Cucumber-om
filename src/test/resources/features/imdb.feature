Feature: Smoke Test
  @SignIn
#  Scenario: Sign in options
#
#    Given that the user clicks on Sign in button from Homepage
#    And user clicks on Sign in to an existing account button
#    Then verify that there are four sign in options present

  Scenario Outline:  Search result test

    Given that the user types '<movie title>' in the searchbar
    And click on search icon
    Then verify that the first option has the movie title that we searched for

    Examples:
    | movie title  |
    |12 angry men  |
    |Shutter island|


  Scenario: Sign in test
    Given that the user clicks on Sign in button from Homepage
    And user clicks on Sign in to an existing account button
    And user clicks on Sign in with IMDb button
    When user inputs email and password
    And clicks on the Sign in button
    Then verify that the user is signed in via the sign out option in profile dropdown



  Scenario Outline: Sign in funcionality with examples
    Given that the user clicks on Sign in button from Homepage
    And user clicks on Sign in to an existing account button
    And user clicks on Sign in with IMDb button
    And user inputs '<email>' and '<password>'
    And clicks on the profile button
    Then verify that the user is logged in

  Examples:
    |email         |password|
    |mock@email.com|Test1234|