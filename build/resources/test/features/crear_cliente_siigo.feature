Feature: Crear nuevo cliente desde el formulario de Clientes

  @CrearCliente
  Scenario: Crear clientes
    Given el usuario accede a la página de login
    When hago login con credenciales validas
    And crear cliente
    Then valido cliente creado con exito





