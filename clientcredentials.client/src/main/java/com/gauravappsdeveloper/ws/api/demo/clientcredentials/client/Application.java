package com.gauravappsdeveloper.ws.api.demo.clientcredentials.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import java.net.URI;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableEurekaClient
public class Application implements CommandLineRunner {

	@Autowired
	DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@ConfigurationProperties("security.oauth2.client")
	public ClientCredentialsResourceDetails oAuthDetails(){
		return  new ClientCredentialsResourceDetails();
	}

	@Bean
	public OAuth2RestTemplate restTemplate(){
		return new OAuth2RestTemplate(oAuthDetails());
	}

	@Override
	public void run(String... args) throws Exception {
		// Call a rest service which is secured with client credentials grant type by a OAuth 2.0 server
		List<ServiceInstance> instances = discoveryClient.getInstances("name of rest service application");
		Random random = new Random();
		// Selecting one Service instance to call at random from the list
		ServiceInstance resourceService = instances.get(random.nextInt(instances.size()));
		URI micro2URI = resourceService.getUri();
		// Get the token automatically and then calling the service
		String response = restTemplate().getForObject(micro2URI + "you url here", String.class);
		// Result from the call will be displayed here
		System.out.println(response);
	}
}
