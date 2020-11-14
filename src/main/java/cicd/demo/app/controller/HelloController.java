package cicd.demo.app.controller;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.json.PackageVersion;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        Version version = PackageVersion.VERSION;
        if (!isValidVersion(version)) {
            throw new RuntimeException("Expected Jackson 2.9.10, but got a different version.");
        }
        return "Hello World";
    }

    private boolean isValidVersion(Version version) {
        return version.getMajorVersion() == 2 && version.getMinorVersion() == 9 && version.getPatchLevel() == 10;
    }
}
