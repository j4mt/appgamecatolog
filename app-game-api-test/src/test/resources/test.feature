Feature: Game trader Catalog e2e Tests


Scenario: List test

    * url appCatalogUrl
    When path '/list'
    And method get
    Then status 200