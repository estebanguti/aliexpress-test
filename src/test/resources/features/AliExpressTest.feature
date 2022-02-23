Feature: Search Products

  Scenario: Customer wants to check that product has available items
    Given Customer goes to Aliexpress website
    When The customer search the next product "Iphone"
    And The customer goes to Result Page 2
    And The customer clicks on product 2
    Then The product should contain available items to buy
