Feature: Login
  Users should be able to log into CargoSphere from the login page.

  Scenario: A user tries logging in
  Given a user is on the login page for the "qaauto" environment
  When the user logs in as "qaauto_super"
  Then the user has auth tokens

  Scenario: A user logs in with the wrong password.
  Given a user is on the login page for the "qaauto" environment
  When the user logs in as "qaauto_super" with the wrong password
  Then the user is on the login page for the "qaauto" environment
  And an invalid username/password error is shown

  Scenario: A user logs in with the correct password, but wrong username.
  Given a user is on the login page for the "qaauto" environment
  When the user logs in as "qaauto_super" with a misspelled username but correct password
  Then the user is on the login page for the "qaauto" environment
  And an invalid username/password error is shown
