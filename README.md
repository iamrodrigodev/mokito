# Mockito (Java) - Guía para seguir el tutorial de Vogella

Este repositorio implementa (en código) los ejercicios principales del tutorial:
[Unit tests with Mockito - Tutorial (Vogella)](https://www.vogella.com/tutorials/Mockito/article.html).

## Requisitos

- Java 17+
- Maven 3.9+

## Cómo ejecutar los tests

Desde la raíz del proyecto:

```bash
mvn test
```

## Estructura del proyecto

- `src/main/java`: código “productivo” (clases del tutorial / ejercicios)
- `src/test/java`: pruebas con JUnit 5 + Mockito
- `docs/capturas`: capturas de pantalla para evidenciar que seguiste el tutorial

## Dónde poner las capturas (lo que pide el profe)

Guarda **todas** las capturas en:

`docs/capturas/`

Convención sugerida: `NN-seccion-descripcion.png` (ordenadas y fáciles de revisar).

### Lista mínima de capturas recomendadas

1) **Proyecto compila y tests pasan**
- Archivo: `docs/capturas/01-mvn-test-ok.png`
- Qué capturar: consola con `mvn test` en verde / BUILD SUCCESS.

2) **Ejercicio 13.2 (VolumeUtilTests)**
- Archivo: `docs/capturas/02-ej-13-2-volumeutiltests.png`
- Qué capturar: ejecución de tests donde se ve `VolumeUtilTests` pasando.

3) **Ejercicio 13.3 (ConfigureThreadingUtilTests)**
- Archivo: `docs/capturas/03-ej-13-3-configurethreadingutiltests.png`
- Qué capturar: ejecución de tests donde se ve `ConfigureThreadingUtilTests` pasando.

4) **Ejercicio 14 (TestingSpy)**
- Archivo: `docs/capturas/04-ej-14-testingspy.png`
- Qué capturar: ejecución de tests donde se ve `TestingSpy` pasando.

5) **Ejercicio 15 (ArticleManagerTest con @InjectMocks)**
- Archivo: `docs/capturas/05-ej-15-injectmocks.png`
- Qué capturar: ejecución de tests donde se ve `ArticleManagerTest` pasando.

6) **Ejercicio 16 (static mocking)**
- Archivo: `docs/capturas/06-ej-16-mockstatic.png`
- Qué capturar: ejecución de tests donde se ve `MyStaticDemoTest` y/o `StaticMockTest` pasando.

7) **Ejercicio 17 (Spy + reflection)**
- Archivo: `docs/capturas/07-ej-17-reflection.png`
- Qué capturar: ejecución de tests donde se ve `MyClassWithPrivateFieldAndMethodTest` pasando.

> Si tu profe pide más evidencias, crea más capturas en esa misma carpeta manteniendo la convención.
