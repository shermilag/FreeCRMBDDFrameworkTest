Feature: Free CRM Login Feature


#without examples keyword
#Scenario: Free CRM Login Test Scenario
#
#Given user is already on Login Page
#When title of login page is Free CRM
#Then user enters "shermilag" and "cutesharmi1"
#Then user clicks on login button
#Then user is on home page


#with examples keyword
Scenario Outline: Free CRM Login Test Scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then close the browser

Examples: 
       | username | password |
       | shermilag | cutesharmi1 |
       | tom | test123 |