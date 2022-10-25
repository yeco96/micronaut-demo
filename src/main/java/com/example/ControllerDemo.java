package com.example;

import com.example.entity.Person;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;

import javax.validation.Valid;

@Controller("v1/demo")
public class ControllerDemo {

    @Get(value = "/helloWorld/{name}", produces = MediaType.APPLICATION_JSON)
    public String hello(@QueryValue String name) {
        return "Hello " + name;
    }

    @Post(value = "/helloWorld", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public String hello(@Valid Person person) {
        return "Hello " + person.getName();
    }
}
