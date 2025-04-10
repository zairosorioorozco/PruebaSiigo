Feature: Crear nuevo cliente desde el formulario de Clientes

  @CrearCliente
  Scenario: Crear clientes
    Given el usuario accede a la página de login
    When hago login con credenciales validas
    And crear cliente
    Then valido cliente creado con exito


  Scenario: Seleccionar tipo valido Persona
    Given el usuario accede a la página de login
    When hago login con credenciales validas
    When selecciona el tipo "Es Persona"
    Then el sistema acepta la selección sin errores






