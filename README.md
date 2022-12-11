# Taller 2 de Spring

Este taller no resulta ser bastante diferencial al enunciado original. Sin embargo, al realizarlo, inicialmente me sentí bastante incomodado por el
hecho de que tuviera la obligación de instanciar 2 servicios con 2 clases distintas y no 1 sola clase tomando diferentes valores en el constructor,
evitando así el código repetido.

Para obtener algo que pudiera cumplimentar lo que pedía el enunciado, he creado una clase "genérica" que las otras 2 clases instancian y ejecutan los
métodos de este objeto genérico, para que cuando otro objeto llame alguno de los métodos de estas 2 clases, ejecute por dentro los del genérico.
