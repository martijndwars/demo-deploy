# CI/CD Demo App

This is a Micronaut application that is built with Maven and depends on Jackson 2.9.10.
[Jackson 2.9.10 has CVEs](https://snyk.io/vuln/maven:com.fasterxml.jackson.core:jackson-databind@2.9.10), so OSSCAN will suggest to upgrade it to 2.10.0: the next version without CVEs.
This upgrade does not result in a compile time error.
However, our not-so-amazing programmer checks at runtime if we are running Jackson 2.9.10.
If this value is anything other than 2.9.10, then a `RuntimeException` is thrown, which Micronaut converts into HTTP 500 errors.
That way we can simulate a dependency upgrade that results in a runtime error, which is then used to rollback the deployment.

## Building

```
mvn clean package
```

## Running

Run the server:

```
java -jar target/cicd-demo-app-0.1.jar
```

Then open the webapp:

```
curl http://localhost:8080/hello
```

To verify, upgrade the dependency manually, rebuild the application, query the endpoint, and see a 500 error.
