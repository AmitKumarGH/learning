package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
//1. Controller that handling http: request
@RestController
public class HelloWorldController {

    //2. Map GET request to URI
    //GET
    //URI - /hello-world
    @GetMapping(path = "/hello-world")
    //method - "Hello World"
    public String helloWorld(){
        return "Hello World";//return simple string back
    }
    @GetMapping(path = "/hello-world-bean")

    public HelloWorldBean helloWorldBean(){
//        throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
        return new HelloWorldBean("Hello World");//return Bean back
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format ("Hello World, %s", name));
    }
}
