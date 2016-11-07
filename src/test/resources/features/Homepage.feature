@web
Feature: Homepage
  As a user,
  I should saw categories at home page,
  so that I would choose the pet.

  @smoke
  Scenario: I could saw categories at homepage
    Given I open homepage
    Then I should see pet store home page