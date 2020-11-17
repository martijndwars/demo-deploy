package cicd.demo.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() throws IOException {
        // Read META-INF/maven/com.google.guava/guava/pom.properties from classpath
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("META-INF/maven/com.google.guava/guava/pom.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String guavaVersion = properties.getProperty("version");
        if (!guavaVersion.equals("23.6-jre")) {
            throw new RuntimeException("Expected Guava 23.6-jre, but got: " + guavaVersion);
        }
        return "Hello World";
    }
}
