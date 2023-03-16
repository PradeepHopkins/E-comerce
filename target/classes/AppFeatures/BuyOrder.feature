
Feature: Buy Order Functionality 
  
  Scenario Outline: user Purchase the product
    Given User search the product "<product>"
    And User select the product
    And  Navigate to add to cart
    Then Validate the product
    When User proceed to checkout
    And User logon "<username>","<password>"
    And slect Address
    And select Payment Options
    Then Make sure that Product is Cancel


     Examples:
    |product    |username                   |password|                      
    |MacBook Air|testautomation259@gmail.com|testautomation|