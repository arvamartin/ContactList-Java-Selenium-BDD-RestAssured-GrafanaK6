Feature: Patch & Put - update


  Scenario Outline: verify the patch api for the contacts
    Given get user's auth token
    And update contact from "PatchBody.json" in "/contacts/<contactID>" "patch" request
    Then receive the 200 response code
    Examples:
      | contactID                |
      | 67fbb82ad9faca0015462680 |


  Scenario Outline: verify the put api for the contacts
    Given get user's auth token
    And update contact from "PutBody.json" in "/contacts/<contactID>" "put" request
    Then receive the 200 response code
    Examples:
      | contactID                |
      | 67fbb82ad9faca0015462680 |

