# CI/CD Demo App

This is a Micronaut application that is built with Maven and depends on Guava 23.9-jre.
[Guava 23.9-jre has CVEs](https://snyk.io/vuln/SNYK-JAVA-COMGOOGLEGUAVA-32236), which means OSSCAN will suggest to upgrade it to 24.0-jre: the next version without CVEs.
This upgrade does not result in a compile time error.
However, our not-so-amazing programmer checks at runtime if we are running Guava 23.9-jre.
If this value is anything other than 23.9-jre, then a `RuntimeException` is thrown, which Micronaut converts into HTTP 500 errors.
That way we can simulate a dependency upgrade that results in a runtime error, which is then used to rollback the deployment.

## Building

```
mvn clean package
```

## Running

First build the application, then following the instructions for running on _Host_ or on _Docker_.

### Run on Host

Run the server:

```
java -jar target/cicd-demo-app-0.1.jar
```

Then open the webapp:

```
curl http://localhost:8080/hello
```

To verify, upgrade the dependency manually, rebuild the application, query the endpoint, and see a 500 error.

## Run in Docker

Build the container, this copies in the built JAR:

```
docker build -t cicd-demo .
```

Run the container and map the port:

```
docker run -p 8080:8080 cicd-demo
```

Then open the webapp:

```
curl http://localhost:8080/hello
```
