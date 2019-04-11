Feature: Game trader Catalog e2e Tests


Scenario: List test

    * url appCatalogUrl
    When path '/list'
    And method get
    And status 200

    Then match $[0].id == 1
    Then match $[0].name == 'Sonic'
    Then match $[0].developer == 'Sega'

    Then match $[1].id == 2
    Then match $[1].name == 'Sonic 2'
    Then match $[1].developer == 'Sega'

    Then match $[2].id == 3
    Then match $[2].name == 'Golden Axe'
    Then match $[2].developer == 'Sega'