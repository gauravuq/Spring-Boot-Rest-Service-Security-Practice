package com.gauravappsdeveloper.ws.api.Method_Level_SecurityResource_Server.controllers;

import com.gauravappsdeveloper.ws.api.Method_Level_SecurityResource_Server.responses.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/status/check")
    public String getStatus(){
        return "Working .." ;
    }

    //@Secured("ROLE_developer")  // change this role to something that is not present in the access token; does not support string security expression;
    @PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject") // here we have to string security expression; this annotation is there to decide if the method should be invoke or not based on what kind of user is currently logged in
    //@PostAuthorize() // this annotation is there to check security expression after the method is done executing
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable  String id, @AuthenticationPrincipal Jwt jwt){
        return "Delete the user with Id ::"+ id+ " JWT Subject Id is ::"+ jwt.getSubject() ;
    }

    @GetMapping("/{id}")
    @PostAuthorize("returnObject.userId == #jwt.subject") // after the method has executed check if the result should be returned or not based on this string security expression
    public User getUser(@PathVariable  String id, @AuthenticationPrincipal Jwt jwt){
        return new User(id,"Gaurav","Sood");
    }

}
