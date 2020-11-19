package com.gauravappsdeveloper.ws.api.Method_Level_SecurityResource_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@SpringBootApplication
public class MethodLevelSecurityResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MethodLevelSecurityResourceServerApplication.class, args);
	}

	@Bean
	public JwtAuthenticationConverter getJwtAuthenticationConverter()
	{
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		return jwtAuthenticationConverter;
	}

}
