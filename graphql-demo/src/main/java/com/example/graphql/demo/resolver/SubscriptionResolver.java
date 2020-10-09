package com.example.graphql.demo.resolver;

import java.time.Duration;
import java.util.Date;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.example.graphql.demo.model.api.Citation;
import com.example.graphql.demo.service.ProteinService;

import reactor.core.publisher.Flux;

@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {

	@Autowired
	ProteinService service;

	public Publisher<Citation> citation(String accession) {
		System.out.println("Subscription : " + new Date());

		return Flux.interval(Duration.ofSeconds(1)).map(num -> getCitation(accession));
	}

	private Citation getCitation(String accession) {
		Citation c = service.getCitation(accession);
		System.out.println("Citation: "+c);
		return c;
	}
}
