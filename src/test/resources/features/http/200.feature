Feature: Status page for json placeholder service

  The service will expose a status page showing its current state
  /http/200.feature

  @status-check
  Scenario: Status check for json placeholder service
    Given an authorised user sends a GET request to the endpoint
    When the status response code will be 200
