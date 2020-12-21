# poc-kotlin-api
Prueba de concepto de un API hecha en Kotlin con Spring Boot.

# Caraceteristicas

* ABM REST de recurso USER.
* Securizado con Spring Security + JWT.
* Acceso a datos con Spring Data.
* Logging core adhoc de request y response.
* Base de datos PostgreSQL

# Colleccion de POSTMAN

* poc-kotlin.postman_collection.json

# Instrucciones

* Para ejecutar, correr la task de Gradle bootRun, pasar por variable de entorno la contraseña de la base de datos "spring.datasource.password"

# TODO

* Guardar logs en base de datos no relacional.
* Implementar esquema CI/CD con AWS.
