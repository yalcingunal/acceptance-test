@basic
Feature: Amazon

  Scenario: Visitor should see Home Page
    When  Visitor is on the HomePage
    Then  Visitor should see Base Url and Base Logo

  Scenario: Customer should log in
    Given Visitor is on the HomePage
    And   Visitor go to the login page
    When  Visitor login with "yalcingunal@gmail.com" email and "y1y1y1" password
    Then  Visitor should see "Hello, yalcin" welcome message on Account Tab

  Scenario Outline: Visitor should search with keyword
    Given Visitor is on the HomePage
    When  Visitor searches with "<keyword>" keyword
    Then  Visitor should see results related with "<keyword>"
    Examples:
      | keyword |
      | samsung |
      | jean    |
      | toy     |

  Scenario: Visitor should search with keyword and goes to product detail
    Given Visitor is on the HomePage
    And   Visitor searches with "samsung" keyword
    When  Visitor goes to "2" th page on the search
    Then  Visitor should be on "2" th page on the search

  Scenario: Visitor should see the clicked product on Product Detail Page
    Given Visitor is on the HomePage
    And   Visitor go to the login page
    And   Visitor login with "yalcingunal@gmail.com" email and "y1y1y1" password
    And   Visitor searches with "samsung" keyword
    And   Visitor goes to "2" th page on the search
    When  Visitor goes to "3" th product on the search
    Then  Visitor should see the clicked product on Product Detail Page

  Scenario: Visitor should added product to List on the List Page
    Given Visitor is on the HomePage
    And   Visitor go to the login page
    And   Visitor login with "yalcingunal@gmail.com" email and "y1y1y1" password
    And   Visitor searches with "samsung" keyword
    And   Visitor goes to "2" th page on the search
    And   Visitor goes to "3" th product on the search
    When  Visitor adds to list product on the Product Detail Page
    Then  Visitor goes to account
    And   Visitor goes to wish list on the Account Page
    And   Visitor should see added product on the List Page