package com.example.graphql.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@SpringBootApplication
@PropertySource("classpath:demo.properties")
public class DemoApplication {

	@Value(("${variation.api}"))
	private String variationAPI;

	@Value(("${protein.api}"))
	private String proteinAPI;

	@Value(("${coordinate.api}"))
	private String coordinateAPI;

	@Value(("${pdbe.api}"))
	private String pdbeAPI;

	@Bean(name = "variantDS")
	@ConfigurationProperties("variant.datasource")
	public DataSource dataSource2(){
	    return DataSourceBuilder.create().build();
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
 
	@Bean
	public GraphQLScalarType jsonType() {
		return ExtendedScalars.Json;
	}

	@Bean
	public RestTemplate variantRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(variationAPI));
		return restTemplate;
	}

	@Bean
	public RestTemplate proteinRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(proteinAPI));
		return restTemplate;
	}

	@Bean
	public RestTemplate coordinateRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(coordinateAPI));
		return restTemplate;
	}

	@Bean
	public RestTemplate pdbeRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(pdbeAPI));
		return restTemplate;
	}
}
