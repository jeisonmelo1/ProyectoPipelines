Feature: Automatizar AdvatageonLine

  @Login

  Scenario Outline: Registro Exitoso

    Given  Que me encuentro en la pagina de registro de advantage '<url>'
    When Realizo el ingreso de mi informacion
      | usuario   | clave   | busqueda   |
      | <usuario> | <clave> | <busqueda> |
    Then Se visualizaria el menu principal "<usuario>"


    Examples:
      | url | usuario | clave | busqueda |
##los datos de puerta23 deben ser reemplazados por el usuario y contraseña que deben crear en la pagina
   |https://www.advantageonlineshopping.com/#/   |Puerta23   |Puerta23   |Laptop|
