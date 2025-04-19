Feature:  Get all contacts from GET api

@test
  Scenario: verify the get api for the contacts
    Given get user's auth token
    When hit the url with auth token
    When pass the "/contacts" url in the request
    Then receive the 200 response code

