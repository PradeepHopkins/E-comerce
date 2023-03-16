
Feature: Buy Order Functionality 
  
  Scenario Outline: user Purchase the product
    Given the user is on the Home page
    When user search the product "<product>"
    And user select the product
    And  Click add to cart
    Then Validate the product
    When Click proceed to checkout
    And User enters username "<username>" and password "<password>" and click login
    And slect Address
    And select Payment Options
    Then Make sure that Product is Cancel


     Examples:
    |product|       |username|                           |password|                      
    |MacBook Air|   |testautomation259@gmail.com|        |testautomation|