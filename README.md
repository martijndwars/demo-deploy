# CI/CD Demo App

This is a Micronaut application that is built with Maven and depends on Jackson 2.9.10.
[Jackson 2.9.10 has CVEs](https://snyk.io/vuln/maven:com.fasterxml.jackson.core:jackson-databind@2.9.10), so OSSCAN will seuggest updating it to 2.10.0: the next version without CVEs.
The upgrade should not be a problem at compile time.
However, our not-so-amazing programmer relies on the value of `com.fasterxml.jackson.core.json.PackageVersion.VERSION`.
If this value is anything other than 2.9.10, a `RuntimeException` is thrown, which Micronaut converts into HTTP 500 errors.

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
