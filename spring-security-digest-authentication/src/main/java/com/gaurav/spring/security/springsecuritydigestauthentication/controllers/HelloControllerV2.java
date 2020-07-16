package com.gaurav.spring.security.springsecuritydigestauthentication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloV2")
public class HelloControllerV2 {


        @GetMapping("/helloWorld")
        public String functionName (String name)
        {
            return "Hello " + name ;
        }


}
