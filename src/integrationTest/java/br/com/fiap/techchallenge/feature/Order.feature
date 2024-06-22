Feature: Tests Api Customer

  Background:
    * url applicationUrl
    Given path '/'

  Scenario: Testando a atualizacao do pagamento
    And path "/order/update-delivery-status"
    And param id = "39341acf-e277-4285-9910-52e5f0961248"
    And param delivery-status = "DONE"
    And header Content-Type = 'application/json'
    When method PATCH
    Then status 200

  Scenario: Testando a busca de um pedido pelo id
    And path "order/find-by-id"
    And param id = "39341acf-e277-4285-9910-52e5f0961248"
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And match response.created == "2024-05-01"
