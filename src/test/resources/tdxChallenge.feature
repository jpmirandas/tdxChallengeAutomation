Feature: TDX Challenge 2.0

  Background: The user accesses the Polishvodka form
    Given I access the Polishvodka website

  Scenario: The user should not access the page without agreeing with page rules
    When I type the age "18"
    And I don't accept the rules
    And I submit the form
    Then I should see an error notification due to don't accept the page rules

  Scenario: The user under 18 years is not allowed to access the page
    When I type the age "17"
    And I accept the rules
    And I submit the form
    Then I should see an error notification due to be under 18

  Scenario Outline: The user should be able to access the page being upper 18 and agree with the rules
    When I type the age "<age>"
    And I accept the rules
    And I submit the form
    Then I should see a successful notification

    Examples:
    | age |
    |  18 |
    |  19 |
