# Mockito en Java - Guia de evidencias

Tutorial base: [https://www.vogella.com/tutorials/Mockito/article.html](https://www.vogella.com/tutorials/Mockito/article.html)

## Requisitos

- Java 17+
- Maven 3.9+

## Formato de presentacion (Tema, Descripcion, Comando, Imagen)

### 1
**Tema:** Prerequisites  
**Descripcion:** Verificar que el proyecto y el entorno de pruebas estan listos.  
**Comando:**
```bash
mvn test
```
**Imagen:** `docs/capturas/01-mvn-test-ok.png`

### 2
**Tema:** State testing vs behavior testing  
**Descripcion:** Validar resultado final y tambien la interaccion con dependencias mockeadas.  
**Comando:**
```bash
mvn -Dtest=StateVsBehaviorTest test
```
**Imagen:** `docs/capturas/02-state-vs-behavior-test.png`

### 3
**Tema:** Creating mock objects with Mockito API  
**Descripcion:** Probar registro de usuario usando `@Mock` y `MockitoExtension`.  
**Comando:**
```bash
mvn -Dtest=UserServiceTest test
```
**Imagen:** `docs/capturas/03-user-service-test.png`

### 4
**Tema:** Testing services with external dependencies  
**Descripcion:** Probar pagos con `PaymentGateway` y auditoria mockeada.  
**Comando:**
```bash
mvn -Dtest=PaymentServiceTest test
```
**Imagen:** `docs/capturas/04-payment-service-test.png`

### 5
**Tema:** Common use cases for Mockito  
**Descripcion:** Verificacion de argumentos, excepciones, asincronia, spy y llamadas multiples.  
**Comando:**
```bash
mvn -Dtest=UserServiceCommonUseCasesTest test
```
**Imagen:** `docs/capturas/05-user-service-common-use-cases-test.png`

### 6
**Tema:** when().thenReturn() basico  
**Descripcion:** Configurar retornos fijos para mocks y validar recuperacion de datos.  
**Comando:**
```bash
mvn -Dtest=UserServiceConfigurationTest test
```
**Imagen:** `docs/capturas/06-user-service-configuration-test.png`

### 7
**Tema:** Return values avanzados y matchers  
**Descripcion:** Probar multiples retornos y comportamiento segun parametros.  
**Comando:**
```bash
mvn -Dtest=UserServiceAdvancedMockingTest test
```
**Imagen:** `docs/capturas/07-user-service-advanced-mocking-test.png`

### 8
**Tema:** when().thenThrow()  
**Descripcion:** Simular fallos de servicios/repositorio y validar manejo de errores.  
**Comando:**
```bash
mvn -Dtest=UserServiceExceptionTest test
```
**Imagen:** `docs/capturas/08-user-service-exception-test.png`

### 9
**Tema:** doReturn().when() con spies  
**Descripcion:** Usar spy de forma segura para evitar invocar comportamiento real no deseado.  
**Comando:**
```bash
mvn -Dtest=UserServiceSpyTest test
```
**Imagen:** `docs/capturas/09-user-service-spy-test.png`

### 10
**Tema:** doThrow().when()  
**Descripcion:** Forzar excepciones en metodos void y validar reacciones esperadas.  
**Comando:**
```bash
mvn -Dtest=UserServiceExceptionHandlingTest test
```
**Imagen:** `docs/capturas/10-user-service-exception-handling-test.png`

### 11
**Tema:** Wrapping objects with Spy  
**Descripcion:** Demostrar uso de `@Spy` en estructuras de datos reales.  
**Comando:**
```bash
mvn -Dtest=MockitoSpyTest test
```
**Imagen:** `docs/capturas/11-mockito-spy-test.png`

### 12
**Tema:** Verify calls on mock objects  
**Descripcion:** Validar numero de llamadas, argumentos y ausencia de interacciones extra.  
**Comando:**
```bash
mvn -Dtest=UserServiceVerificationTest test
```
**Imagen:** `docs/capturas/12-user-service-verification-test.png`

### 13
**Tema:** Using @InjectMocks  
**Descripcion:** Inyeccion automatica de mocks por constructor para crear objeto bajo prueba.  
**Comando:**
```bash
mvn -Dtest=ArticleManagerInjectMocksTest test
```
**Imagen:** `docs/capturas/13-article-manager-inject-mocks-test.png`

### 14
**Tema:** Capturing arguments  
**Descripcion:** Capturar lista pasada al mock y validar contenido con `ArgumentCaptor`.  
**Comando:**
```bash
mvn -Dtest=MockitoArgumentCaptureTest test
```
**Imagen:** `docs/capturas/14-mockito-argument-capture-test.png`

### 15
**Tema:** Using Answers for complex mocks  
**Descripcion:** Respuestas dinamicas con callbacks y comportamiento segun argumentos.  
**Comando:**
```bash
mvn -Dtest=MockitoAnswersTest test
```
**Imagen:** `docs/capturas/15-mockito-answers-test.png`

### 16
**Tema:** Mocking final classes and static methods (parte 1)  
**Descripcion:** Probar mock de clase final y creacion de mock estatico.  
**Comando:**
```bash
mvn -Dtest=MockitoMockFinalTest test
```
**Imagen:** `docs/capturas/16-mockito-mock-final-test.png`

### 17
**Tema:** Mocking static methods (parte 2)  
**Descripcion:** Mockear metodos estaticos concretos con diferentes entradas.  
**Comando:**
```bash
mvn -Dtest=MyUtilsTest test
```
**Imagen:** `docs/capturas/17-my-utils-test.png`

### 18
**Tema:** Strict stubs rule  
**Descripcion:** Mostrar comportamiento de strict stubs para mantener tests limpios.  
**Comando:**
```bash
mvn -Dtest=StrictStubsTest test
```
**Imagen:** `docs/capturas/18-strict-stubs-test.png`

### 19
**Tema:** Exercise 13.2 - Testing VolumeUtil  
**Descripcion:** Validar comportamiento segun modo de timbre en `AudioManager`.  
**Comando:**
```bash
mvn -Dtest=VolumeUtilTests test
```
**Imagen:** `docs/capturas/19-volume-util-tests.png`

### 20
**Tema:** Exercise 13.3 - ConfigureThreadingUtil  
**Descripcion:** Verificar lectura de configuracion de hilos en `MyApplication`.  
**Comando:**
```bash
mvn -Dtest=ConfigureThreadingUtilTests test
```
**Imagen:** `docs/capturas/20-configure-threading-util-tests.png`

### 21
**Tema:** Exercise 14 - Use @Spy  
**Descripcion:** Stub de indice alto en lista espia usando `doReturn`.  
**Comando:**
```bash
mvn -Dtest=TestingSpy test
```
**Imagen:** `docs/capturas/21-testing-spy.png`

### 22
**Tema:** Exercise 15 - Use @InjectMocks  
**Descripcion:** Probar inicializacion de `ArticleManager` e interacciones esperadas.  
**Comando:**
```bash
mvn -Dtest=ArticleManagerTest test
```
**Imagen:** `docs/capturas/22-article-manager-test.png`

### 23
**Tema:** Exercise 16 - Static mock demo  
**Descripcion:** Validar mock de metodos estaticos con variantes de parametros.  
**Comando:**
```bash
mvn -Dtest=MyStaticDemoTest test
```
**Imagen:** `docs/capturas/23-my-static-demo-test.png`

### 24
**Tema:** Exercise 16.1 - Bigger static mock example  
**Descripcion:** Revisar escenarios amplios de mock estatico y verificacion.  
**Comando:**
```bash
mvn -Dtest=StaticMockTest test
```
**Imagen:** `docs/capturas/24-static-mock-test.png`

### 25
**Tema:** Exercise 17 - Spy + reflection + private members  
**Descripcion:** Cambiar campo privado e invocar metodo privado mediante reflection.  
**Comando:**
```bash
mvn -Dtest=MyClassWithPrivateFieldAndMethodTest test
```
**Imagen:** `docs/capturas/25-private-field-method-test.png`
