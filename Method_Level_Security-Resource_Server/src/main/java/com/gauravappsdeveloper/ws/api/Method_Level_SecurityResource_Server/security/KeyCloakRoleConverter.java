package com.gauravappsdeveloper.ws.api.Method_Level_SecurityResource_Server.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.*;

@Configuration
public class KeyCloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {


    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {

        Map<String, Object> allTheClaimsPresentInJWT = jwt.getClaims();  //get the map of all the claims
        Map<String, Object> realm_access = (Map<String, Object>) allTheClaimsPresentInJWT.get("realm_access");  // get the key from the previous map which is in turn a map
        if (realm_access == null || realm_access.isEmpty()) {
            return new ArrayList<>();
        }
        Collection<GrantedAuthority> grantedAuthorityCollection = ((List<String>) realm_access.get("roles"))
                .stream()
                .map(role -> "ROLE_" + role)
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());

        return grantedAuthorityCollection;
    }
}
