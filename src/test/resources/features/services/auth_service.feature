Feature: To check login and get auth token
  Scenario: User calls auth to login 
    Given I want to execute service /api/auth/
    When I read the json data file "json/auth-login.json"
    Then I send the json post request to endpoint "login"
    When I validate status code
    Then I verify the result message param "accessToken"
    