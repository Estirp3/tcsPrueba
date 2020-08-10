Feature: Vuelo economico Latam

 # Yo como Usuario
 # Quiero buscar un vuelo en Latam
 # Para seleccionar el vuelo más económico


  Scenario: Validar la información de búsqueda y selección del vuelo más económico para que la información llegue de forma exitosa a Paso 3.
    Given como cliente ingreso a la url "https://www.latam.com/es_cl/"
    When  Selecciono los datos requeridos para buscar vuelo
     And  doy click en boton busca tu vuelo
     And  selecciono vuelo mas economico en pantalla
    Then  Se verifica monto del vuelo y que se este en el paso tres de seis

