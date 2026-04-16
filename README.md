# Mockito en Java - Guia para presentar el tutorial completo

Tutorial base:
[https://www.vogella.com/tutorials/Mockito/article.html](https://www.vogella.com/tutorials/Mockito/article.html)

## Requisitos

- Java 17 o superior
- Maven 3.9 o superior

## Temas del tutorial (de inicio a fin)

1. **Prerequisites**  
   Preparacion del entorno Java y pruebas con JUnit 5.

2. **Using Mockito for mocking objects in unit tests**  
   Que es un mock, por que usar Mockito, capacidades, limites y enfoque de pruebas.

3. **Adding Mockito to a project**  
   Configuracion de dependencias en Maven/Gradle para usar Mockito.

4. **Creating mock objects with the Mockito API**  
   Creacion de mocks con `@Mock`, `mock()` y `MockitoExtension`.

5. **Common use cases for Mockito**  
   Casos comunes: dependencias externas, argumentos, errores, asincronia, spies e interacciones multiples.

6. **Configuring return values on mocks**  
   Uso de `when().thenReturn()`, `thenThrow()`, `doReturn()`, `doThrow()`.

7. **Wrapping Java objects with Spy**  
   Uso de `@Spy` y verificacion de llamadas en objetos espia.

8. **Using @InjectMocks**  
   Inyeccion automatica de dependencias mockeadas.

9. **Capturing arguments**  
   Captura de argumentos con `ArgumentCaptor`.

10. **Using Answers for complex mocks**  
    Respuestas dinamicas segun argumentos y callbacks.

11. **More on Mockito**  
    Mock de clases `final`, metodos estaticos y enfoque de strict stubs.

12. **Exercise: project with Mockito support**  
    Estructura del proyecto y configuracion base para correr tests.

13. **Exercise: API testing (AudioManager)**  
    Pruebas de `VolumeUtil` y `ConfigureThreadingUtil`.

14. **Exercise: use @Spy**  
    Prueba de spy en colecciones.

15. **Exercise: use @InjectMock(s)**  
    Modelo simple e inyeccion de mocks en `ArticleManager`.

16. **Exercise: mocking final/static**  
    Pruebas de metodos estaticos y casos mas grandes de mock static.

17. **Exercise: spy + reflection + private members**  
    Cambio de campo privado e invocacion de metodo privado por reflection.

18. **Conclusion**  
    Buenas practicas para mantener pruebas claras y confiables.

19. **Resources**  
    Referencias oficiales y enlaces de apoyo.

## Carpeta de capturas

Guardar todas las capturas en:

`docs/capturas/`

## Capturas y comando (debajo de cada una)

1. **`docs/capturas/01-mvn-test-ok.png`**  
   Comando:
   ```bash
   mvn test
   ```

2. **`docs/capturas/02-state-vs-behavior-test.png`**  
   Comando:
   ```bash
   mvn -Dtest=StateVsBehaviorTest test
   ```

3. **`docs/capturas/03-user-service-test.png`**  
   Comando:
   ```bash
   mvn -Dtest=UserServiceTest test
   ```

4. **`docs/capturas/04-payment-service-test.png`**  
   Comando:
   ```bash
   mvn -Dtest=PaymentServiceTest test
   ```

5. **`docs/capturas/05-user-service-common-use-cases-test.png`**  
   Comando:
   ```bash
   mvn -Dtest=UserServiceCommonUseCasesTest test
   ```

6. **`docs/capturas/06-user-service-configuration-test.png`**  
   Comando:
   ```bash
   mvn -Dtest=UserServiceConfigurationTest test
   ```

7. **`docs/capturas/07-user-service-advanced-mocking-test.png`**  
   Comando:
   ```bash
   mvn -Dtest=UserServiceAdvancedMockingTest test
   ```

8. **`docs/capturas/08-user-service-exception-test.png`**  
   Comando:
   ```bash
   mvn -Dtest=UserServiceExceptionTest test
   ```

9. **`docs/capturas/09-user-service-spy-test.png`**  
   Comando:
   ```bash
   mvn -Dtest=UserServiceSpyTest test
   ```

10. **`docs/capturas/10-user-service-exception-handling-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=UserServiceExceptionHandlingTest test
    ```

11. **`docs/capturas/11-mockito-spy-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=MockitoSpyTest test
    ```

12. **`docs/capturas/12-user-service-verification-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=UserServiceVerificationTest test
    ```

13. **`docs/capturas/13-article-manager-inject-mocks-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=ArticleManagerInjectMocksTest test
    ```

14. **`docs/capturas/14-mockito-argument-capture-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=MockitoArgumentCaptureTest test
    ```

15. **`docs/capturas/15-mockito-answers-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=MockitoAnswersTest test
    ```

16. **`docs/capturas/16-mockito-mock-final-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=MockitoMockFinalTest test
    ```

17. **`docs/capturas/17-my-utils-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=MyUtilsTest test
    ```

18. **`docs/capturas/18-strict-stubs-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=StrictStubsTest test
    ```

19. **`docs/capturas/19-volume-util-tests.png`**  
    Comando:
    ```bash
    mvn -Dtest=VolumeUtilTests test
    ```

20. **`docs/capturas/20-configure-threading-util-tests.png`**  
    Comando:
    ```bash
    mvn -Dtest=ConfigureThreadingUtilTests test
    ```

21. **`docs/capturas/21-testing-spy.png`**  
    Comando:
    ```bash
    mvn -Dtest=TestingSpy test
    ```

22. **`docs/capturas/22-article-manager-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=ArticleManagerTest test
    ```

23. **`docs/capturas/23-my-static-demo-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=MyStaticDemoTest test
    ```

24. **`docs/capturas/24-static-mock-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=StaticMockTest test
    ```

25. **`docs/capturas/25-private-field-method-test.png`**  
    Comando:
    ```bash
    mvn -Dtest=MyClassWithPrivateFieldAndMethodTest test
    ```
