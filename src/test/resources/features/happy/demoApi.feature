Feature: Status page for json placeholder service

  The service will expose a status page showing its current state
  /http/200.feature

  @happypath
  Scenario: Status check for json placeholder service
    Given an authorised user sends a GET request to the endpoint
    When the status response code will be 200
    Then the user ID is 1, the ID is 1, the title is "delectus aut autem", and it is not completed

  @notsohappypath
  Scenario: Status check for json placeholder service
    Given an authorised user sends a GET request to the endpoint
    When the status response code will be 200
    Then the response contains the following TodoItem details:
      | userId     | 1                  |
      | id         | 1                  |
      | title      | delectus aut autem |
      | completed  | false              |