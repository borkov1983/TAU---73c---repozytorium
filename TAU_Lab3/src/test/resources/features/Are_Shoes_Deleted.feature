Feature: Buy Shoes
  Customer buys shoes

  Scenario: Customer buy a shoes
    Given Customer chooses a shoes from list and buy
    When Customer choose model "Puma"
    And Customer choose size equal 43
    Then shoes has been bought and removed from list of shoes
