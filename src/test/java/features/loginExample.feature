# use the syntax @tagname to add tags on the scenarios

# this tag means, all the scenarios to run

@all  
Feature: Rediff Login page

# It is used to write comments in feature file


# The below statement demonstrates the use of Background Keyword
Background: # this defines the pre-condition
 Given I am on RediffPage

# The below lines demonstrates the use of Example to password data for data driver testing
@login @regression @smoke
Scenario Outline: Enter email and password on rediffPage
   
    When I enter '<EmailID>' on the page
    And I enter '<Password>' on the Page 
    And click on Login
  Examples:
  |EmailID|Password|
  |admin@gmail.com|admin@123|
  
  
 @CreateAccount @regression
  Scenario: Click on Create Account Page
  When I click on Create new Account Link
  Then fetch the title of the Page
  
 
  # The below lines demonstrates the use of data table to pass multiple data
   @register
  Scenario: Enter details on the Registration Page
   When I click on Create new Account Link
   Then User Enters the folliwng registration details
   | FullName | EmailID | Password | retype | alternate | phone |
   | Marc | marc@rediffid.com | password | retypePassword | alternate@gmail.com | 2343534646 |
   | Mia | marc@rediffid.com | password1 | retypePassword | alternate@gmail.com | 2343534646 |
   | James | marc@rediffid.com | password2 | retypePassword | alternate@gmail.com | 2343534646 |
  
  
  
