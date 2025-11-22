# Kata Números romanos

[![Coverage Status](https://coveralls.io/repos/github/leogil02/challenge-possumus/badge.svg)](https://coveralls.io/github/leogil02/challenge-possumus)

[![Coverage](https://github.com/leogil02/challenge-possumus/actions/workflows/coverage.yml/badge.svg)](https://github.com/leogil02/challenge-possumus/actions/workflows/coverage.yml)

##Desafío a realizar

### Fase 1

Desarrollar un componente que permita convertir números enteros a romanos y viceversa según el siguiente esquema: 

* 1 ➔ I
* 2 ➔ II
* 3 ➔ III
* 4 ➔ IV
* 5 ➔ V
* 9 ➔ IX
* 21 ➔ XXI
* 50 ➔ L
* 100 ➔ C
* 500 ➔ D
* 1000 ➔ M


En ambos métodos de conversión, el componente debe validar si se ingresa un valor no permitido y responder con una excepción personalizada. 

**Plus Fase 1:** Aplicar TDD o al menos hacer Tests unitarios del componente probando al menos 2 border cases para cada método de conversión.


### Fase 2 

Exponer el método del componente que convierte valores numéricos arábigos a romanos en un endpoint (GET) 
Exponer el método del componente que convierte valores numéricos romanos a arábigos en un endpoint (GET)

**Plus Fase 2:** Aplicar TDD (Test de integración usando la suite de Spring). 


### Requerimientos/Restricciones

**Fase 1 y 2:** Usar Java 17 o superior. Maven o Gradle para la gestión de dependencias. 
Para los puntos plus de cada fase, en lo relacionado a la infraestructura de tests se pueden usar las siguientes herramientas JUnit5+Mockito o Spock y Spring Boot Testing. 
**Fase 2:** Usar Spring boot 3+.

Completar y modificar este readme e incluirlo como parte del repositorio agregando detalles sobre cómo construir el proyecto desde cero y ponerlo en ejecución. 

##Pre - requisitos
- Docker instalado
- Docker compose instalado
- Puerto 8080 libre

##Correr aplicación
docker compose up --build roman-numbers-api

##Correr tests
docker composer up --build roman numbers-tests

##Tecnologías utilizadas
- Java 21
- Spring Boot 4.0.0

##Decisiones tomadas
- Arquitectura en capas con influencia de arquitectura hexagonal: para poder organizar mejor la estructura del proyecto y poder manejar cambios a futuro de una forma apropiada
- Docker: para hacer la aplicación portatil
- JUnit/Mockito/Spring Testing: ya que son las herramientas más utilizadas y las apropiadas para utilizar en conjunto y realizar tests correctamente

##Rutas
- : [![API SWAGGER](http://localhost:8080/swagger-ui/index.html)]
