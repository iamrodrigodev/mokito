# Mockito (Java) - Full tutorial checklist for screenshots

This project follows the tutorial:
[Unit tests with Mockito - Tutorial (Vogella)](https://www.vogella.com/tutorials/Mockito/article.html)

## Requirements

- Java 17+
- Maven 3.9+

## Run all tests

```bash
mvn test
```

## Where to put screenshots

Save every screenshot in:

`docs/capturas/`

Suggested naming:

`NN-test-class-name.png`

## Screenshot checklist (one per test class)

Use this command pattern for each class:

```bash
mvn -Dtest=ClassName test
```

1. `docs/capturas/01-mvn-test-ok.png` - full suite (`mvn test`)
2. `docs/capturas/02-state-vs-behavior-test.png` - `StateVsBehaviorTest`
3. `docs/capturas/03-user-service-test.png` - `UserServiceTest`
4. `docs/capturas/04-payment-service-test.png` - `PaymentServiceTest`
5. `docs/capturas/05-user-service-common-use-cases-test.png` - `UserServiceCommonUseCasesTest`
6. `docs/capturas/06-user-service-configuration-test.png` - `UserServiceConfigurationTest`
7. `docs/capturas/07-user-service-advanced-mocking-test.png` - `UserServiceAdvancedMockingTest`
8. `docs/capturas/08-user-service-exception-test.png` - `UserServiceExceptionTest`
9. `docs/capturas/09-user-service-spy-test.png` - `UserServiceSpyTest`
10. `docs/capturas/10-user-service-exception-handling-test.png` - `UserServiceExceptionHandlingTest`
11. `docs/capturas/11-mockito-spy-test.png` - `MockitoSpyTest`
12. `docs/capturas/12-user-service-verification-test.png` - `UserServiceVerificationTest`
13. `docs/capturas/13-article-manager-inject-mocks-test.png` - `ArticleManagerInjectMocksTest`
14. `docs/capturas/14-mockito-argument-capture-test.png` - `MockitoArgumentCaptureTest`
15. `docs/capturas/15-mockito-answers-test.png` - `MockitoAnswersTest`
16. `docs/capturas/16-mockito-mock-final-test.png` - `MockitoMockFinalTest`
17. `docs/capturas/17-my-utils-test.png` - `MyUtilsTest`
18. `docs/capturas/18-strict-stubs-test.png` - `StrictStubsTest`
19. `docs/capturas/19-volume-util-tests.png` - `VolumeUtilTests`
20. `docs/capturas/20-configure-threading-util-tests.png` - `ConfigureThreadingUtilTests`
21. `docs/capturas/21-testing-spy.png` - `TestingSpy`
22. `docs/capturas/22-article-manager-test.png` - `ArticleManagerTest`
23. `docs/capturas/23-my-static-demo-test.png` - `MyStaticDemoTest`
24. `docs/capturas/24-static-mock-test.png` - `StaticMockTest`
25. `docs/capturas/25-private-field-method-test.png` - `MyClassWithPrivateFieldAndMethodTest`

## Notes for the report

- In each screenshot, show the command and the result with tests passing.
- Keep all screenshots in order (`01`, `02`, ..., `25`).
- If your teacher asks for package/class code evidence, add one extra screenshot per package from `src/test/java`.
