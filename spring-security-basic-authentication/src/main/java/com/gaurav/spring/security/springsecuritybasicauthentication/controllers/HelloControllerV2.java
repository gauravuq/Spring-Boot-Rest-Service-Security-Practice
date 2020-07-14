package com.gaurav.spring.security.springsecuritybasicauthentication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControllerV2 {


        @GetMapping("/helloWorld")
        public String functionName (String name)
        {
            return "Hello " + name ;
        }


}
