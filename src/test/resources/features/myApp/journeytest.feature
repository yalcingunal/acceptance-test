@journey_casestudy
Feature: Amazon Case

  Scenario: Visitor should remove product from List on the List Page
    Given Visitor is on the HomePage
    And   Visitor go to the login page
    And   Visitor login with "yalcingunal@gmail.com" email and "y1y1y1" password
    And   Visitor searches with "samsung" keyword
    And   Visitor goes to "2" th page on the search
    And   Visitor goes to "3" th product on the search
    And   Visitor adds to list product on the Product Detail Page
    And   Visitor goes to account
    And   Visitor goes to wish list on the Account Page
    When  Visitor removes product on the List Page
    Then  Visitor should see empty list on the List Page