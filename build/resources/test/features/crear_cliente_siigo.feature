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

#  Scenario: Ingresar tipo inválido
#    Given el usuario accede a la página de login
#    When hago login con credenciales validas
#    When ingresa "@Persona" como tipo
#    Then el sistema debe mostrar un mensaje de error de validación
#  #Valores Límite
#  Scenario: Ingresar número de teléfono con 7 dígitos
#    Given el usuario accede a la página de login
#    When hago login con credenciales validas
#    When ingresa "3214567" como número de teléfono
#    Then el sistema debe aceptar el número como válido
#  Scenario: Ingresar más de 50 caracteres en Apellidos
#    Given el usuario accede al formulario de datos básicos
#    When ingresa "PérezGómezMartínezRodríguezHernándezLópezSánchezGarcíaRamírez" como apellidos
#    Then el sistema debe mostrar un mensaje indicando que excede el límite de caracteres
#  #Tabla de Decisión
#  Scenario: Mostrar campo DV para Empresa con NIT
#    Given el usuario selecciona "Empresa" como tipo
#    And selecciona "NIT" como tipo de identificación
#    Then el sistema debe mostrar el campo "DV"
#  Scenario: Ocultar campo DV con Pasaporte
#    Given el usuario selecciona "Empresa" como tipo
#    And selecciona "Pasaporte" como tipo de identificación
#    Then el sistema no debe mostrar el campo "DV"
#  #Transición de Estados
#  Scenario: Mostrar campo Nombre Comercial al cambiar tipo a Empresa
#    Given el usuario ha seleccionado "Persona" como tipo
#    When cambia el tipo a "Empresa"
#    Then el campo "Nombre comercial" debe aparecer como obligatorio
#  Scenario: Eliminar el número de teléfono y validar mínimo
#    Given el usuario ha ingresado un número de teléfono válido
#    When elimina el número de teléfono
#    Then el sistema debe indicar que el campo es obligatorio con mínimo 7 dígitos




