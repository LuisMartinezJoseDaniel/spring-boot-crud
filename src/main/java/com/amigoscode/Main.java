package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

@RestController
public class Main {

    public static void main(String[] args) {
        //Run Spring boot in this Main class
        SpringApplication.run(Main.class, args);
    }
//    @GetMapping("/greet")
    @RequestMapping(method = RequestMethod.GET, path = "/greet")
    public GreetResponse greet(){
        GreetResponse response= new GreetResponse("Hello world",
                List.of("Java", "Typescript", "Javascript"),
                new Person("Dan", 23, 12.2));
        return response;
    }
//    record === Java class with getters and setters but records have immutability with properties as final
    record  GreetResponse(String greet, List<String> favProgramingLanguages, Person person) {}
    record Person (String name, int age, double savings){}
}
