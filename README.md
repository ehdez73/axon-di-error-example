# Sample application with Axon Framework 

Demo application to check that the Axon's ParameterResolver fails in tests within regular @CommandHandler annotated methods (no constructor)
but works when we run it normally.

```
$ ./gradlew bootRun | grep Hello
2019-09-20 12:14:59.982  INFO 78662 --- [           main] c.g.ehdez73.demo.axondi.domain.Customer  : Hello 1:Elmo
2019-09-20 12:15:00.187  INFO 78662 --- [           main] c.g.ehdez73.demo.axondi.domain.Customer  : Hello 1:Sesame Street
```

``` 
$ ./gradlew clean test
...
Starting a Gradle Daemon, 1 incompatible and 1 stopped Daemons could not be reused, use --status for details

> Task :test FAILED

com.github.ehdez73.demo.axondi.domain.CustomerTest > testUpdate FAILED
    org.axonframework.test.FixtureExecutionException at CustomerTest.java:51

2 tests completed, 1 failed

```  