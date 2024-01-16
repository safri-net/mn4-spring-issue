package com.example

import groovy.transform.CompileStatic
import io.micronaut.spring.context.MicronautApplicationContext
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@CompileStatic
@SpringBootApplication
class Application {

    static void main(String[] args) {
        new SpringApplicationBuilder()
                .parent(new MicronautApplicationContext().tap { start() })
                .sources(Application)
                .build()
                .run()
    }
}

@RestController
class MyController {

    @GetMapping
    String hello() {
        return "hallo"
    }
}