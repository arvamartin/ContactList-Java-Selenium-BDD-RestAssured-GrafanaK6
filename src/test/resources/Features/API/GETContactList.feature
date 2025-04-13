Feature:  Get all contacts from GET api

  Scenario: verify the get api for the contacts
    Given hit the url of contacts api endpoint
    When pass the url of contacts in the request
    Then receive the 200 response code

