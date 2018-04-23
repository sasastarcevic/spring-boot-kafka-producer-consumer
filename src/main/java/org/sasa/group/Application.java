package org.sasa.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@ComponentScan(basePackages = "org.sasa.group")
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

