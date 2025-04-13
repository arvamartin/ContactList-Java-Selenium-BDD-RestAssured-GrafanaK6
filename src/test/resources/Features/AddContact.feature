Feature: Adding new contact functionality

  Background:
    Given user is already on the "https://thinking-tester-contact-list.herokuapp.com/login" page
    When user enters "test@freemail.hu" email address
    And user enters "tesztelek" password
    And user clicks on the submit button

  Scenario: user can add new contact to table
    When user clicks on add new contact button
    And user enters firstname
    And user enters lastname
    And user enters acceptable email
    And user enters acceptable phone number
    And user clicks on the submit button
    Then user is on the "https://thinking-tester-contact-list.herokuapp.com/contactList" page
    And new contact is in the contact table

