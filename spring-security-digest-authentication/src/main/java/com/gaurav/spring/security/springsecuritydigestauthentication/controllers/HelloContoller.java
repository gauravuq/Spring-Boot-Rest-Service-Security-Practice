package com.gaurav.spring.security.springsecuritydigestauthentication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloContoller {

    @GetMapping("/helloWorld")
    public String functionName (String name)
    {
    return "Hello " + name ;
    }

}
