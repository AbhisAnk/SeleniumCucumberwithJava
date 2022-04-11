#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: This feature is used to test functionlaities availble on landing page
  I want to use this template for my feature file

  @signup	
  Scenario: This scenario will test signup feature of the application
    Given User navigates to application landing page
    When User perform signup process with valid userName and password
    Then User should be signedup successfully
    
    
  @login	
  Scenario: This scenario will test login feature of the application
    Given User navigates to application landing page
    When User perform login process with valid userName and password
    Then User should be loggedin successfully  

#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
