Feature: Status page for json placeholder service

  The service will expose a status page showing its current state
  /http/200.feature

  @status-check
  Scenario: Status check for json placeholder service
    When an authorised user sends a GET request to the endpoint
    Then the status response code will be 200
    And the user ID is 1, the ID is 1, the title is "delectus aut autem", and it is not completed
