FROM openjdk:14-alpine
COPY target/cicd-demo-app-*.jar cicd-demo-app.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "cicd-demo-app.jar"]