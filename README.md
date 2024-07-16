# Code Challenge

Desarrollar una API Restful en Kotlin o Java para un sistema bancario que reciba transacciones a procesar.

La API recibirá las transacciones a procesar en el endpoint `/api/transaction` (solo admite metodo `POST`). Una vez recibida la transacción, se deberá procesar de forma asincrónica, por lo que encolará la transacción pendiente (puede ser en memoria o en disco) para luego ser procesadas de forma paralela (implementar thread pool).

El sistema deberá tener precargada una cuenta de prueba, la cual será accesible bajo el endpoint `/api/account` usando el método `GET`, y deberá devolver todos los datos de la cuenta en formato JSON.

Una cuenta está compuesta por:
- ID (número de cuenta)
- Banco (nombre del banco)
- País (nombre del país origen)
- Saldo

Una transacción está compuesta principalmente por:
- Cuenta origen
- Cuenta destino
- Monto a transferir

Lo que conocemos como Transacción, deberá tener un método "calcularImpuesto", el cual será implementado dependiendo el tipo de transacción.

Existen 2 tipos de transacciones
- Nacionales
- Internacionales

Si bien ambos tipos de transacción deberán compartir los mismos atributos (cuenta origen, cuenta destino, monto transferido), la diferencia esta en que en las transacciones internacionales se cobra como impuesto, el 5% del valor del monto a transferir a la cuenta origen, en cambio en una transacción nacional, solo se cobra el 1% en caso que las cuentas sean de diferentes bancos. En caso de pertenecer al mismo banco, no se cobrara nada. Toda esta lógica para calcular el costo de la
transacción se deberá implementar en el método calcularImpuesto mencionado anteriormente.

Tener en consideración que el sistema recibirá muchas transacciones al mismo tiempo, por lo que puede existir problemas de concurrencia durante el procesamiento de las mismas.

A modo de bitácora, la API deberá guardar en un archivo .txt todas las transacciones procesadas con el estado de cada una.

Desarrollar un Unit Test para asegurar el buen funcionamiento del método calcularImpuesto para ambos tipos de transacciones.