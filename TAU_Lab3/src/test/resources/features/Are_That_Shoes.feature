Feature: Are there Adidas shoes with size number 43?
  Client wants to know.

  Scenario: Client wants to buy his favorite brand shoes.
    Given Client decided to look at the shoes
    When Client says Bring me all shoes named "Adidas"
    And Bring me all shoes with size equal 43
    Then Seller should brings him 2 pairs shoes.


