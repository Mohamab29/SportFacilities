package com.sports.sport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@EnableSwagger2
@SpringBootApplication
public class SportApplication {

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public static void main(String[] args) {
        SpringApplication.run(SportApplication.class, args);
    }

}
