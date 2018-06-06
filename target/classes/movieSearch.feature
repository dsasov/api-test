Feature: Search for movies

Scenario: Verify movie name
  Given user searches for pulp+fiction
  When user sends request
  Then user receives JSON response
  And JSON contains Pulp Fiction