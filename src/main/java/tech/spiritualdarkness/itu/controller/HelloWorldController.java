package tech.spiritualdarkness.itu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/says")
    public String say(){
        return "Hello World";
    }

}
