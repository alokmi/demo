package com.example.graphql.demo.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import com.example.graphql.demo.model.PDBeRequest;
import com.example.graphql.demo.model.api.DataServiceCoordiante;
import com.example.graphql.demo.model.api.DataServiceProtein;
import com.example.graphql.demo.model.api.DataServiceVariation;

@Service
public class UniprotAPIRepoImpl implements UniprotAPIRepo {

	@Autowired
	private RestTemplate variantRestTemplate;

	@Autowired
	private RestTemplate proteinRestTemplate;

	@Autowired
	private RestTemplate coordinateRestTemplate;

	@Autowired
	private RestTemplate pdbeRestTemplate;

	private static final Logger logger = LoggerFactory.getLogger(UniprotAPIRepoImpl.class);

	private static final String PARAM_ACCESSION = "accession";

	@Override
	public DataServiceVariation getVariation(String accession) {
		DefaultUriBuilderFactory handler = (DefaultUriBuilderFactory) this.variantRestTemplate.getUriTemplateHandler();
		UriBuilder uriBuilder = handler.builder().path(accession);

		ResponseEntity<DataServiceVariation> response = this.variantRestTemplate.getForEntity(uriBuilder.build(),
				DataServiceVariation.class);
		return response.getBody();
	}

	@Override
	public DataServiceProtein getProtein(String accession) {
		DefaultUriBuilderFactory handler = (DefaultUriBuilderFactory) this.proteinRestTemplate.getUriTemplateHandler();
		UriBuilder uriBuilder = handler.builder().queryParam(PARAM_ACCESSION, accession);
		ResponseEntity<DataServiceProtein[]> response = this.proteinRestTemplate.getForEntity(uriBuilder.build(),
				DataServiceProtein[].class);
		return response.getBody()[0];
	}

	@Override
	public DataServiceCoordiante getGene(String accession) {
		DefaultUriBuilderFactory handler = (DefaultUriBuilderFactory) this.coordinateRestTemplate
				.getUriTemplateHandler();
		UriBuilder uriBuilder = handler.builder().queryParam(PARAM_ACCESSION, accession);
		ResponseEntity<DataServiceCoordiante[]> response = this.coordinateRestTemplate.getForEntity(uriBuilder.build(),
				DataServiceCoordiante[].class);
		return response.getBody()[0];
	}

	@Override
	public Object getPDBe(String accession, long begin) {
		DefaultUriBuilderFactory handler = (DefaultUriBuilderFactory) this.pdbeRestTemplate.getUriTemplateHandler();
		UriBuilder uriBuilder = handler.builder();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		PDBeRequest request = new PDBeRequest();
		request.setAccession(accession);
		List<String> positions = new ArrayList<String>();
		positions.add(new Long(begin).toString());
		request.setPositions(positions);
		HttpEntity<List<PDBeRequest>> requestEntity = new HttpEntity<List<PDBeRequest>>(Arrays.asList(request), headers);
		ResponseEntity<Object[]> response = this.pdbeRestTemplate.postForEntity(uriBuilder.build(), requestEntity,
				Object[].class);

		return response.getBody()[0];

	}

}
