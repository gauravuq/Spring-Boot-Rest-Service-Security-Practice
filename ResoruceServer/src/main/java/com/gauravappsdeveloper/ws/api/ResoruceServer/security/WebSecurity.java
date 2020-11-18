package com.gauravappsdeveloper.ws.api.ResoruceServer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtAuthenticationConverter jwtAuthenticationConverter;

    @Autowired
    KeyCloakRoleConverter keyCloakRoleConverter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(keyCloakRoleConverter);
        http
        .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/users/status/check")
                //.hasAuthority("SCOPE_profile")  // fine grained control for a url based on authorities/Scope // can add new scope to keycloak
                .hasRole("developer") // or use hasAuthority("ROLE_developer") // fine grained control for a url based on authorities/Role
                // needs a converter class for to know granted authorities.
        .anyRequest()
        .authenticated()
        .and()
        .oauth2ResourceServer()
        .jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
    }
}
