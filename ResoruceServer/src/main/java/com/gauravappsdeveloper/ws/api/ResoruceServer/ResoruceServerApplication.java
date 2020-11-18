package com.gauravappsdeveloper.ws.api.ResoruceServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@SpringBootApplication
public class ResoruceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResoruceServerApplication.class, args);
	}

	@Bean
	public JwtAuthenticationConverter getJwtAuthenticationConverter()
	{
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		return jwtAuthenticationConverter;
	}


}
