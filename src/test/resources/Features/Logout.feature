Feature: Logout functionality

  Background:
    Given user is already on the "https://thinking-tester-contact-list.herokuapp.com/login" page
    When user enters "test@freemail.hu" email address
    And user enters "tesztelek" password
    And user clicks on the submit button

  Scenario: user can logout
    When user clicks on the logout button
    Then user is on the "https://thinking-tester-contact-list.herokuapp.com/" page