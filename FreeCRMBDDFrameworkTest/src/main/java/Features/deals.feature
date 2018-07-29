Feature: Free CRM Create Deals


Scenario: Free CRM Create Deals scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user enters username and password
| shermilag | cutesharmi1 |
Then user clicks on login button
Then user is on home page
Then user moves to new deals page
Then user enters new deals details 
| test1 | google | 3 | hello |

Then close the browser


